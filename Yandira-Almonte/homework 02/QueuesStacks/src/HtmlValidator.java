import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {
	
	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
		Stack <HtmlTag> tagStack = new Stack<>();
		while(!tags.isEmpty()){
			HtmlTag tag=tags.remove();
			if(tag.isSelfClosing()) continue;
			if(tag.isOpenTag())
				tagStack.push(tag);
			else{
				if(!tagStack.isEmpty()){
						if(tag.matches(tagStack.peek()))
							tagStack.pop();
						else	break;
					}
				else if(!tag.isOpenTag())
						return null;
				}
		}
		return tagStack; 
	}

}

