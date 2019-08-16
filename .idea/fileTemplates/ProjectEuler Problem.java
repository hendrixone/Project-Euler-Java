#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")
/**
 * Description:
 * ${NAME}, NAME
 * INFO
 */
public class ${NAME} {
    /*
    Solution description here
    */
    private static String solve() {
        //TODO
        return "Answer Here";
    }
    
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: "+result+"\nProcess took "+(endTime - startTime)/1000+"ms to execute");
    }
}
/*
Put result here
*/