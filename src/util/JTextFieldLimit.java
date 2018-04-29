package util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class JTextFieldLimit extends PlainDocument {
	
	private static final long serialVersionUID = -6755510745239694794L;
	
	public JTextFieldLimit(int limit, boolean integer)
	{
		super();
		
		if (integer)
			setDocumentFilter(new MyDocumentFilter(limit));
	}
}

class MyDocumentFilter extends DocumentFilter {
	
	public int limit;
	
	public MyDocumentFilter(int limit)
	{
		this.limit = limit;
	}
	
	@Override
	public void insertString(FilterBypass fb, int off, String str, AttributeSet attr) throws BadLocationException
	{
		if (fb.getDocument().getLength() + str.length() >= 4)
			return;
		
		// remove non-digits
		fb.insertString(off, str.replaceAll("\\D++", ""), attr);
	}
	
	@Override
	public void replace(FilterBypass fb, int off, int len, String str, AttributeSet attr) throws BadLocationException
	{
		// remove non-digits
		fb.replace(off, len, str.replaceAll("\\D++", ""), attr);
	}
}
