package oppts.task;

import oppts.OPPTSNodeContext;
import oppts.communication.nqueen.NQueenTaskStatusMessage;

/**
 *
 * @author jmishra
 */
public class NQueensTask extends AbstractTask implements Runnable {

    private int n;

    @Override
    public void run() {
        int[] board = new int[n]; //hold the column position of n queens
        placeQueenOnBoard(0, board);
    }

    private static void placeQueenOnBoard(int Qi, int[] board) {
        int n = board.length;
        //base case
        if (Qi == n) {// a valid configuration found.
            //  System.out.println(Arrays.toString(board));
        } else {
            //try to put the ith Queen (Qi) in all of the columns
            for (int column = 0; column < n; column++) {

                NQueenTaskStatusMessage status = new NQueenTaskStatusMessage();
                status.setNumberOfColumnsHandled(column);
                status.setPercentageOver(((column + 1) / (float) n) * 100);
                status.setDestinationHostName(OPPTSNodeContext.getInstance().getNodeManagerHostName());
                status.setDestinationPort(OPPTSNodeContext.getInstance().getNodeManagerPort());
                OPPTSNodeContext.getInstance().getOutgoingQueue().insertMessage(status);

                if (isSafePlace(column, Qi, board)) {
                    board[Qi] = column;
                    //then place remaining queens.
                    placeQueenOnBoard(Qi + 1, board);
                    board[Qi] = -1;
                }
            }
        }

        NQueenTaskStatusMessage status = new NQueenTaskStatusMessage();
        status.setNumberOfColumnsHandled(n);
        status.setPercentageOver(100);
        status.setOver(true);
        status.setDestinationHostName(OPPTSNodeContext.getInstance().getNodeManagerHostName());
        status.setDestinationPort(OPPTSNodeContext.getInstance().getNodeManagerPort());
        OPPTSNodeContext.getInstance().getOutgoingQueue().insertMessage(status);
    }

    //check if the column is safe place to put Qi (ith Queen)
    private static boolean isSafePlace(int column, int Qi, int[] board) {

        //check for all previously placed queens
        for (int i = 0; i < Qi; i++) {
            if (board[i] == column) { // the ith Queen(previous) is in same column
                return false;
            }
            //the ith Queen is in diagonal
            //(r1, c1) - (r2, c1). if |r1-r2| == |c1-c2| then they are in diagonal
            if (Math.abs(board[i] - column) == Math.abs(i - Qi)) {
                return false;
            }
        }
        return true;
    }

}
