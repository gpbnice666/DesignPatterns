package com.bo.dataStructure.rbTree;

/**
 * 任意一个节点所包含的键值，大于等于左孩子的键值，小于等于右孩子的键值
 * @author gpb
 * @param <T>
 */
public class RBTree<T extends Comparable<T>> {

    /**
     * 跟节点
     */
    private RBTNode<T> mRoot;

    private static final boolean RED = false;
    private static final boolean BLACK = true;

    public class RBTNode<T extends Comparable<T>>{
        /**
         * 颜色
         */
        boolean color;

        /**
         * 关键字 键值
         */
        T key;

        /**
         * 左孩子
         */
        RBTNode<T> left;

        /**
         * 右孩子
         */
        RBTNode<T> right;

        /**
         * 父节点
         */
        RBTNode<T> parent;

        public RBTNode(T key, boolean color, RBTNode<T> parent, RBTNode<T> left, RBTNode<T> right) {
            this.key = key;
            this.color = color;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }



    public RBTree(){
        this.mRoot = null;
    }

    /**
     * 获取 该节点的父节点
     * @param node
     * @return
     */
    private RBTNode<T> parentOf(RBTNode<T> node){
        return node != null ? node.parent : null;
    }

    /**
     * 获取这个节点颜色
     * @param node
     * @return
     */
    private boolean colorOf(RBTNode<T> node){
        return node != null ? node.color : BLACK;
    }

    /**
     * 判断该节点是否为红色
     * @param node
     * @return
     */
    private boolean isRed(RBTNode<T> node){
        return ((node != null) && (node.color == RED)) ? true : false;
    }

    /**
     * 设置为黑色
     * @param node
     */
    private void setBlack(RBTNode<T> node){
        if(node != null)
            node.color = BLACK;
    }

    /**
     * 设置为红色
     * @param node
     */
    private void setRed(RBTNode<T> node){
        if(node != null)
            node.color = RED;
    }

    /**
     * 设置父节点
     * @param node
     */
    private void setParent(RBTNode<T> node,RBTNode<T> parent){
        if(node != null)
            node.parent = parent;
    }

    /**
     * 设置颜色
     */
    private void setColor(RBTNode<T> node, boolean color){
        if (node!=null)
            node.color = color;
    }

    /**
     * 提供外界调用
     */
    public void perOrder(){
        preOrder(mRoot);
    }

    /**
     * 提供外界调用
     */
    public void inOrder(){
        inOrder(mRoot);
    }

    /**
     * 提供外界调用
     */
    public void postOrder(){
        postOrder(mRoot);
    }

    /**
     * 前序遍历"红黑树"
     * @param tree
     */
     private void preOrder(RBTNode<T> tree) {
     if(tree != null) {
            System.out.print(tree.key+" ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    /**
     * 中序遍历"红黑树
     * @param tree
     */
    private void inOrder(RBTNode<T> tree) {
         if(tree != null) {
             inOrder(tree.left);
             System.out.print(tree.key+" ");
             inOrder(tree.right);
         }
    }

    /**
     * 后序遍历"红黑树
     * @param tree
     */
    private void postOrder(RBTNode<T> tree) {
        if(tree != null)
        {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(tree.key+" ");
        }
    }

    /**
     * 递归查询 红黑树中是否存在key
     * @param x
     * @param key
     * @return
     */
    private RBTNode<T> search(RBTNode<T> x,T key){
        if(x == null)
            return x;
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
            return search(x.left,key);
        if(cmp > 0)
            return search(x.right,key);
        return x;
    }

    /**
     * 提供外界调用查询
     * @param key
     * @return
     */
    public RBTNode<T> search(T key){
        return search(mRoot,key);
    }

    /**
     * 循环查询红黑树 是否存在key
     * @param x
     * @param key
     * @return
     */
    private RBTNode<T> iterativeSearch(RBTNode<T> x,T key){
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if(cmp < 0)
                x = x.left;
            else if(cmp > 0)
                x = x.right;
            else
                return x;
        }
        return x;
    }

    /**
     * 提供外界使用循环查找
     * @param key
     * @return
     */
    public RBTNode<T> iterativeSearch(T key){
        return iterativeSearch(mRoot,key);
    }

    /**
     * 查找出最大节点
     * @param tree
     * @return
     */
    private RBTNode<T> maximum(RBTNode<T> tree){
        if(tree == null)
            return null;
        while (tree.right != null)
            tree = tree.right;
        return tree;
    }

    /**
     * 对红黑树的节点x 进行左旋转
     *          px                               px
     *        /                                 /
     *       x           --进行左旋 --->>        y
     *      / \                                /\
     *     lx  y                              x  ry
     *        / \                             /\
     *       ly  ry                          lx ly
     * @param x
     */
    private void leftRotate(RBTNode<T> x){
        // 设置x的右孩子为y
        RBTNode<T> y = x.right;
        // 将 y的左孩子 ly 设置为 x的右孩子
        // 如果y的左孩子非空， 将 x 设置 y的左孩子的父亲
        x.right = y.left;
        if (y.left != null)
            y.left.parent = x;

        // x的父亲 设置为 y的父亲
        y.parent = x.parent;
        if(x.parent == null)
            // 如果x的父亲为null , 则将y设为跟节点
            this.mRoot = y;
        else
            // 如果 x是父亲的左孩子, 那么y 设置为 x的父节点的左孩子
            if(x.parent.left == x)
                x.parent.left = y;
            else
                // 否则说明 x是父亲的左孩子，那么 y 设置为 x的父节点的 左孩子
                x.parent.right = y;

        //将 x 设置为 y的左孩子
        y.left = x;
        // x 的父节点 设置为y
        x.parent = y;
    }

    /** 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
     * 对红黑树进行 右旋转
     *            py                            px
     *           /                              /
     *          y(小 中)   --进行右旋 --->>       x
     *         /\                              /\
     *  x(小于y) ry                            lx y
     *       /\                                  /\
     *      lx rx                               rx ry
     * @param y
     */
    private void rightRotate(RBTNode<T> y){
        // 设置x  是y当前节点的左孩子
        RBTNode<T> x = y.left;

        // 将 x的右孩子 设置为 y的左孩子
        y.left = x.right;
        // 如果 x的右孩子不为null 把y 设置为 x的右孩子
        if(x.right != null)
            x.right = y;
        // 将x的父亲 设置为 y的父亲
        x.parent = y.parent;
        if(y.parent == null)
            // 如果y的父节点是null 就把跟节点设置为x
            this.mRoot = x;
        else
            if (y == y.parent.right)
                // 如果 y的父节点的右孩子是y,则将x设置为 y节点的右孩子
                y.parent.right = x;
            else
            // 否则说明 y是父亲的左孩子，那么 x 设置为 y的父节点的 左孩子
                y.parent.left = x;
        // 将y 设置为 x的右孩子
        y.right = x;
        // 将y的父节点设置为x
        y.parent = x;
    }

    /**
     * 新建节点key, 并将其插入红黑树中
     * @param key 插入红黑树的节点
     */
    public void insert(T key){
        RBTNode<T> node = new RBTNode<T>(key, BLACK, null, null, null);
        if(node != null)
            insert(node);
    }

    /**
     * 将节点插入红黑树中
     * @param node
     */
    public void insert(RBTNode<T> node){
        // 两个节点的比较大小的值
        int cmp;
        RBTNode<T> y = null;
        RBTNode<T> x = this.mRoot;

        // 将红黑树当作一颗二叉查找树,将节点添加都二叉树中
        while (x != null) {
            y = x;
            cmp = node.key.compareTo(x.key);
            // 如果是小于说明在左节点进行查找
            if(cmp < 0)
                x.left = x.left;
            else
                // 是大于 右孩子进行查找
                x.right = x.right;
        }
        node.parent = y;
        if(y != null){
            cmp = node.key.compareTo(y.key);
            if(cmp < 0)
                y.left = node;
            else
                // 是大于 右孩子
                y.right = node;
        }else
            this.mRoot = node;

        // 将节点设置为红色
        node.color = RED;

        // 将他进行一些列的旋转修正一个真正的红黑树
        insertFixUp(node);
    }

    /**
     * 红黑树插入修正函数
     *
     * 在红黑树中插入节点之后失去平衡,在调用该函数
     * 目的是将它重新塑造成一颗红黑树
     * @param node
     */
    private void insertFixUp(RBTNode<T> node) {
        //         节点的父节点,父节点的父节点 爷爷节点
        RBTNode<T> parent,gparent;

        // 若 父节点存在,并且父节点的颜色是红色
        while(((parent = parentOf(node)) != null) && isRed(parent)){
            gparent = parentOf(parent);

            // 如果父节点 是 祖父节点的左孩子
            if (gparent.left == parent){
                // Case1 祖父节点的右孩子是红色
                RBTNode<T> gright = gparent.right;
                if((gright != null) && isRed(gright)){
                    // 遵循 如果一个父节点是红色 两个字节是黑色
                    setBlack(gright);
                    setBlack(parent);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }
                // Case2 父节点的右孩子是黑色,且当前节点是 祖父节点的右孩子
                if(parent.right == node){
                    RBTNode<T> tmp;
                    leftRotate(parent);
                    tmp = parent;
                    parent = node;
                    node = tmp;
                }
                // Case3 父节点是黑色，,切实当前左孩子
                setBlack(parent);
                setRed(gparent);
                rightRotate(gparent);
            }else { // 父节点 是 爷爷节点的左孩子
                // 爷爷的左孩子
                RBTNode<T> uncle = gparent.left;
                if(uncle != null && isRed(uncle)){
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }
                // Case2:叔叔是黑色、且当前节点是左孩子
                if(parent.left == node){
                    RBTNode<T> tmp;
                    rightRotate(parent);
                    tmp = parent;
                    parent = node;
                    node = tmp;
                }
                // Case3: 叔叔是黑色,且当前节点是右孩子
                setBlack(parent);
                setRed(gparent);
                leftRotate(gparent);
            }
        }
        // 根节点设为黑色
        setBlack(this.mRoot);
    }



}
