import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {
	
	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
        Stack<HtmlTag> stackResult = new Stack<HtmlTag>();
        for(HtmlTag value:tags) {
            if(itContainsOnlyClosedTags(tags)||itContainsMoreClosedTags(tags)){
                return null;
            }
            if(value.isSelfClosing()){
                continue;
            }
            if(value.isOpenTag() && !value.isSelfClosing()){
                stackResult.push(value);

            }else if(value.matches(stackResult.peek())){
                if(stackResult.lastElement().element.equals(value.element)){
                    stackResult.pop();
                }
            } else { break;}
        }
		return stackResult;
	}

	public static boolean itContainsOnlyClosedTags(Queue<HtmlTag> queueTags){
        for(HtmlTag tag: queueTags) {
            if(tag.openTag){
                return false;
            }
        }
        return true;
    }

    public static boolean itContainsMoreClosedTags(Queue<HtmlTag> queueTags){
	    int countOpen = 0;
	    int countClosed = 0;
        for(HtmlTag tag: queueTags) {
            if(tag.openTag){
                countOpen++;
            }else{
                countClosed++;
            }
        }
        if(countClosed > countOpen) {
            return true;
        }else{
            return false;
        }
    }

}

