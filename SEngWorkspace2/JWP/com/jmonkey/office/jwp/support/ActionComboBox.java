package jmonkey.office.jwp.support;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Hashtable;

import javax.swing.Action;
import javax.swing.JComboBox;

/**
 * General purpose Action combo-box class.
 */
public final class ActionComboBox extends JComboBox implements ItemListener {
  private final Hashtable m_actions = new Hashtable();
  
  public ActionComboBox() {
    super();
    this.addItemListener(this);
  }
  
  //for testing only
  public Hashtable getActions(){
	  return m_actions;
  }
  
  public ActionComboBox(Action[] items) {
    super();
    if (items!=null)//added
    {
	    for (int i = 0; i < items.length; i++) {
	      this.addItem(items[i]);
	    }
    }
    this.addItemListener(this);
  }
  
  public void addItem(Action a) {
	  if(a==null) return;//added
      String name = (String) a.getValue(Action.NAME);
      if (!m_actions.containsKey(name)) {
        m_actions.put(name, a);
        super.addItem(name);
      }
  }
  
  
  
  public Object getItemAt(int index) {
	  	//added
	  	if(index<0 || index>m_actions.size())
		  return null;
	    String name = (String) super.getItemAt(index);
	    if (m_actions.containsKey(name)) {
	      return ((Action) m_actions.get(name));
	    } 
	    else {
	      return null;//Consider removing for 100% coverage. Only occurs if an index exits for a non present item
	    }
  }
  
  public void insertItemAt(Action a, int index) {
	  //Added detection of null arguments
	  if(a != null && index<=m_actions.size() && index>=0)
	  {
	      String name = (String) a.getValue(Action.NAME);
	      if (!m_actions.containsKey(name)) {
	        m_actions.put(name, a);
	        super.insertItemAt(name, index);
	      }
	  }
  }
  
  public void itemStateChanged(ItemEvent e) {
	    String name = (String) e.getItem();
	    Action action = (Action) m_actions.get(name);
	    if (action != null) {
	      ActionEvent event = 
	        new ActionEvent(this, ActionEvent.ACTION_PERFORMED, name);
	      action.actionPerformed(event);
	    }
	  }
  
  public void removeAllItems() {
    m_actions.clear();
    super.removeAllItems();
  }
  
  public void removeItem(Object anObject) {
	if(anObject==null)return;//added
    throw new UnsupportedOperationException("removeItem(Object)"); 
  }

  public void removeItemAt(int anIndex) {
	  if(anIndex<0 || anIndex>=m_actions.size())return;//added
    throw new UnsupportedOperationException("removeItemAt(int)");
  }
}
