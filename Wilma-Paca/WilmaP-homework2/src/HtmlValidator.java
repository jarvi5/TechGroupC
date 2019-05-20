import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {
	
	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
		
		/* IMPLEMENT THIS METHOD! */
		Stack<HtmlTag> tagsStack= new Stack();
		
		while(!tags.isEmpty() ) {
				if(tags.peek().isOpenTag()) {
					tagsStack.push(tags.peek());
					tags.poll();					
				}else {
					
				if(!tags.peek().isSelfClosing()) {
					if(tags.size()==1 && tagsStack.isEmpty()) {									
						tagsStack.push(tags.peek());
						tags.clear();
						return null;
					}
						if((tagsStack.peek().matches(tags.peek()))) {
							tagsStack.pop();
							tags.poll();
							}else {
								tags.clear();								
							}
					
					}else {
						
						tags.poll();
						
					}						
				
				}
			}
		
		return tagsStack; // this line is here only so this code will compile if you don't modify it
	}
	
}

