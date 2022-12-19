public class Page {
    // Page set up for usage.
    public String section;
    public String defaultCode;
    public String defaultOut;
    public boolean editable;

    public String descText;
    public boolean hasTask;

    public String patternStr1 = "";
    public boolean mustInclude1 = false;
    public String taskDesc1 = "";

    public String patternStr2 = "";
    public boolean mustInclude2 = false;
    public String taskDesc2 = "";

    public String patternStr3 = "";
    public boolean mustInclude3 = false;
    public String taskDesc3 = "";

    public Page(String s, String dC, String dO, boolean e, String dT, boolean hT, String pS1, boolean mI1, String tD1, String pS2, boolean mI2, String tD2, String pS3, boolean mI3, String tD3){
        section = s;
        defaultCode = dC;
        defaultOut = dO;
        editable = e;
        
        descText = dT;
        hasTask = hT;

        patternStr1 = pS1;
        mustInclude1 = mI1;
        taskDesc1 = tD1;

        patternStr2 = pS2;
        mustInclude2 = mI2;
        taskDesc2 = tD2;

        patternStr3 = pS3;
        mustInclude3 = mI3;
        taskDesc3 = tD3;
    }

    // hasTask False most likely, won't need to bother with the other Vars.
    public Page(String s, String dC, String dO, boolean e, String dT, boolean hT){
        section = s;
        defaultCode = dC;
        defaultOut = dO;
        editable = e;
        
        descText = dT;
        hasTask = hT;
    }

    public Object[] getFields(){
        return new Object[]{section, defaultCode, defaultOut, editable, descText, hasTask, patternStr1, mustInclude1, taskDesc1, patternStr2, mustInclude2, taskDesc2, patternStr3, mustInclude3, taskDesc3};
    }
}