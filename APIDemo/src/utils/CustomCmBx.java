/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Carlos Esquivel
 */
public class CustomCmBx {
    public static class Model extends DefaultComboBoxModel implements ComboBoxModel, ListDataListener {
        private DefaultComboBoxModel original;

        public Model(DefaultComboBoxModel original) {
            super();
            this.original = original;

        }

        @Override
        public int getSize() {
            return original.getSize();
        }

        @Override
        public Object getElementAt(int index) {
            return original.getElementAt(index);
        }

        @Override
        public void addListDataListener(ListDataListener l) {
            if (getListDataListeners().length == 0) {
                original.addListDataListener(this);
            }
            super.addListDataListener(l);
        }

        @Override
        public void removeListDataListener(ListDataListener l) {
            super.removeListDataListener(l);
            if (getListDataListeners().length == 0) {
                original.removeListDataListener(this);
            }
        }

        @Override
        public void addElement(Object anObject) {
            original.addElement(anObject);
        }

        @Override
        public void removeElement(Object anObject) {
            original.removeElement(anObject);
        }

        @Override
        public int getIndexOf(Object anObject) {
            return original.getIndexOf(anObject);
        }

        @Override
        public void insertElementAt(Object anObject, int index) {
            original.insertElementAt(anObject, index);
        }

        @Override
        public void removeAllElements() {
            original.removeAllElements();
        }

        @Override
        public void removeElementAt(int index) {
            original.removeElementAt(index);
        }

        @Override
        public void intervalAdded(ListDataEvent e) {
            fireIntervalAdded(this, e.getIndex0(), e.getIndex1());
        }

        @Override
        public void intervalRemoved(ListDataEvent e) {
            fireIntervalRemoved(this, e.getIndex0(), e.getIndex1());
        }

        @Override
        public void contentsChanged(ListDataEvent e) {
            fireContentsChanged(this, e.getIndex0(), e.getIndex1());
        }

    }
}
