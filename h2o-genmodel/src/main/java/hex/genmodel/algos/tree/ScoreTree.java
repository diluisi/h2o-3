package hex.genmodel.algos.tree;

public interface ScoreTree {

  double scoreTree(byte[] tree, double[] row, int nclasses, boolean computeLeafAssignment, String[][] domains);

}
