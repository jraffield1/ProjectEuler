package barnvonproto.projecteulermaven;


import java.util.ArrayList;

public class Node
{
    public ArrayList<Node> nodeList;
    public int value;
    public int row;

    public Node()
    {
        nodeList = new ArrayList<>();
        value = -1;
        row = -1;
    }

    public Node(int a, int b)
    {
        nodeList = new ArrayList<>();
        value = a;
        row = b;
    }
    
    public void connect(Node n)
    {
        nodeList.add(n);
        n.nodeList.add(this);
    }
    
    public String toString()
    {
        String s = "(" + value + ") -> ";

        for(Node n : nodeList)
            s += n.value + "-";

        return s;
    }
};