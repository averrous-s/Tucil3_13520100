package Tree;
import java.util.ArrayList;

public abstract class TreeNode <T>{
    public T val;
    public ArrayList<TreeNode<T>> childs;

    public TreeNode(T p) {
        this.val = p;
        this.childs = new ArrayList<TreeNode<T>>();
    }

    public abstract <U extends T> void expand();
    
}