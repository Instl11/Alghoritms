package tree;

import lombok.Getter;

import java.util.*;

public class TreeTest {
    public static void main(String[] args) {
        Tree root =
                new Tree(20,
                        new Tree(7,
                                new Tree(4, null, new Tree(6)),
                                new Tree(9)),
                        new Tree(35,
                                new Tree(31, new Tree(28), null),
                                new Tree(40, new Tree(38), new Tree(52))));

        int sum = Tree.sumWoRecursion(root);
        System.out.println(sum);

    }
}

@Getter
class Tree {
    private int value;
    private Tree left;
    private Tree right;

    public Tree(int value, Tree left, Tree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Tree(int value) {
        this.value = value;
    }

    public static int sumWithRecursion(Tree root) {
        int sum = root.value;

        if (root.left != null) {
            sum += sumWithRecursion(root.left);
        }

        if (root.right != null) {
            sum += sumWithRecursion(root.right);
        }
        return sum;
    }

    public static int sumWoRecursion(Tree root) {
        Stack<Tree> stack = new Stack<>();
        stack.push(root);
        int sum = 0;

        while (!stack.isEmpty()) {
            Tree node = stack.pop();
            sum += node.value;

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return sum;
    }
}