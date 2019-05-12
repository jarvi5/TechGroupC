import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {

    public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
        Stack<HtmlTag> stack = new Stack<>();
        while (!tags.isEmpty()) {
            HtmlTag tag = tags.poll();
            if (tag.isOpenTag()) {
                stack.push(tag);
            } else if (!stack.isEmpty() && !tag.isSelfClosing()) {
                if (stack.peek().matches(tag)) {
                    stack.pop();
                } else {
                    return stack;
                }
            } else if (!tag.isSelfClosing()) {
                return null;
            }
        }
        return stack;
    }
}

