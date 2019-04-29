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

        for (HtmlTag tag : tags) {
            if (tag.isSelfClosing()) {
                continue;
            }

            if (tag.openTag) {
                stack.push(tag);
            } else if (stack.empty()) {
                return null;
            }

            if (!tag.openTag) {
                if (stack.peek().matches(tag)) {
                    stack.pop();
                } else {
                    return stack;
                }
            }
        }
        return stack;
    }
}

