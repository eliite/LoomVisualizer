/* Jacek Strotz
 * CCustomFilter
 * October 20, 2021
 * 
 * Description: I know this program allowed dirty inputs. However, that is one
 * of my biggest software pet peeves. I researched for about an hour to find
 * the easiest method to filter a JTextField. Originally, I began by writing
 * a key char handler attached to the keyPressed event. This didn't work;
 * however, because the Document was only adjusted after the keyPressed and 
 * keyTyped events had conceded. This would cause removing the "dirty" letter
 * to actually remove the preceding letter and have the dirty letter added 
 * anyway by the Document controller. Therefore, I found my solution: writing
 * a DocumentFilter override with FilterBypass.
 *
 * Purpose: To guarantee a flawless experience after the user clicks "Process
 * User Inputs."
 */ 

package regex;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class CustomFilter extends DocumentFilter {
    private String regex;
    private Integer max_char;
    
    public CustomFilter(String a, Integer b) {
        regex = a;
        max_char = b;
    }
    
    @Override
    public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {

        String text = fb.getDocument().getText(0, fb.getDocument().getLength());
        text += string;

        if(text.matches(regex)) {
            super.insertString(fb, offset, string, attr);
        }
    }

    /**
     * Called when the user pastes in new text.
     */
    @Override
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {

        String string = fb.getDocument().getText(0, fb.getDocument().getLength());
        string += text;

        if(string.matches(regex)) {
            super.replace(fb, offset, length, text, attrs);
        }
    }

    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        super.remove(fb, offset, length); // I may modify this later
    }
    
    public JTextField adjustField(JTextField field) {
        //JTextField field = new JTextField();
        
        AbstractDocument document = (AbstractDocument) field.getDocument();
        document.setDocumentFilter(new DocumentFilter() {
            public void replace(FilterBypass fb, int offs, int length,
                    String str, AttributeSet a) throws BadLocationException {

                String text = fb.getDocument().getText(0,
                        fb.getDocument().getLength());
                text += str;
                if ((fb.getDocument().getLength() + str.length() - length) <= max_char
                        && text.matches(regex)) {
                    super.replace(fb, offs, length, str, a);
                }
            }

            public void insertString(FilterBypass fb, int offs, String str,
                    AttributeSet a) throws BadLocationException {

                String text = fb.getDocument().getText(0,
                        fb.getDocument().getLength());
                text += str;
                if ((fb.getDocument().getLength() + str.length()) <= max_char
                        && text.matches(regex)) {
                    super.insertString(fb, offs, str, a);
                }
            }
        });
        
        return field;
    }
    
    public JPasswordField adjustField(JPasswordField field) {
        AbstractDocument document = (AbstractDocument) field.getDocument();
        document.setDocumentFilter(new DocumentFilter() {
            public void replace(FilterBypass fb, int offs, int length,
                    String str, AttributeSet a) throws BadLocationException {

                String text = fb.getDocument().getText(0,
                        fb.getDocument().getLength());
                text += str;
                if ((fb.getDocument().getLength() + str.length() - length) <= max_char
                        && text.matches(regex)) {
                    super.replace(fb, offs, length, str, a);
                }
            }

            public void insertString(FilterBypass fb, int offs, String str,
                    AttributeSet a) throws BadLocationException {

                String text = fb.getDocument().getText(0,
                        fb.getDocument().getLength());
                text += str;
                if ((fb.getDocument().getLength() + str.length()) <= max_char
                        && text.matches(regex)) {
                    super.insertString(fb, offs, str, a);
                }
            }
        });
        
        return field;
    }
}
