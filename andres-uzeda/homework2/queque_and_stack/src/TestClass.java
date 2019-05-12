import java.io.IOException;
import java.util.Queue;
import java.util.Stack;

import static java.util.Collections.reverse;

public class TestClass {
    //{ Queue localQueue = HtmlReader.getTagsFromHtmlFile(pathToTestFiles + paramString)
    public static void main(String[] paramArrayOfString) {
        try {
            Queue<HtmlTag> localQueue = HtmlReader.getTagsFromHtmlFile("./homework2-files/test6.html");
            for(HtmlTag value:localQueue) {
                System.out.println(value.openTag +" - "+ value.element);
            }
            System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
            Stack<HtmlTag> stackResult = new Stack<HtmlTag>();
            for(HtmlTag value:localQueue) {
                if(itContainsOnlyClosedTags(localQueue)){
                    //return null;
                }else{
                    if(!value.openTag){
                        if(stackResult.lastElement().element.equals(value.element)){
                            stackResult.pop();
                        }
                    }else if(value.openTag && !value.element.equals("!doctype") && !value.element.equals("!--") && !value.element.equals("img") && !value.element.equals("link") && !value.element.equals("meta")){
                        stackResult.push(value);
                    }
                }
            }
            for(HtmlTag value:stackResult) {
                System.out.println(value.openTag +" - "+ value.element);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean itContainsOnlyClosedTags(Queue<HtmlTag> queueTags){
        for(HtmlTag tag: queueTags) {
            if(tag.openTag){
                return false;
            }
        }
        return true;
    }
}
