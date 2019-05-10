import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {
    /**
     * Method that verify if a Queue with HtmlTag have a valid Html Format
     *
     * @param tags Queue of HtmlTag information.
     * @return Stack of HtmlTag.
     */
    public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
        Stack<HtmlTag> result = new Stack<>();
        for (HtmlTag tag : tags) {
            if (tag.isSelfClosing()) continue;
            if (result.isEmpty() && !tag.isOpenTag()) return null;
            if (tag.isOpenTag()) {
                result.push(tag);
            } else if (tag.matches(result.peek())) {
                result.pop();
            } else break;
        }
        return result;
    }
}

