import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {

    public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
        Stack<HtmlTag> result = new Stack<>();
        if (tags.size() != 0) {
            result = getHtmlTagsStack(tags, result);
        }
        return result;
    }

    private static Stack<HtmlTag> getHtmlTagsStack(Queue<HtmlTag> tags, Stack<HtmlTag> result) {
        for (HtmlTag data : tags) {
            if (data.isOpenTag()) {
                result.push(data);
            } else {
                if (!data.isSelfClosing()) {
                    if (!result.isEmpty()) {
                        if (matchTags(result, data)) break;
                    } else {
                        result = null;
                        break;
                    }
                }
            }
        }
        return result;
    }

    private static boolean matchTags(Stack<HtmlTag> result, HtmlTag data) {
        if (data.matches(result.peek())) {
            result.pop();
        } else {
            return true;
        }
        return false;
    }
}
