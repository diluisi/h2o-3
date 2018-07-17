package water.rapids.ast.prims.advmath;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import water.H2O;
import water.TestUtil;
import water.fvec.Frame;
import water.fvec.TestFrameBuilder;
import water.fvec.Vec;
import water.rapids.Rapids;
import water.rapids.Val;
import water.rapids.vals.ValFrame;
import water.util.TwoDimTable;

import static org.junit.Assert.assertEquals;

public class AstRunifTest extends TestUtil {

  @BeforeClass
  static public void setup() { stall_till_cloudsize(1); }

  private Frame fr = null;

  @Before
  public void beforeEach() {

  }

  @Test
  public void RunifTest() {

    fr = new TestFrameBuilder()
            .withName("testFrame")
            .withColNames("ColA")
            .withVecTypes(Vec.T_NUM)
            .withDataForCol(0, ard(1, 2, 3))
            .build();
    String tree = "(h2o.runif testFrame 1234.0 )";
    Val val = Rapids.exec(tree);
    if (val instanceof ValFrame)
      fr = val.getFrame();

    TwoDimTable twoDimTable = fr.toTwoDimTable();

    System.out.println(twoDimTable.toString());

    // TODO pass more values into the column and check whether distribution is normal
  }

  @After
  public void afterEach() {
    H2O.STORE.clear();
  }


}
