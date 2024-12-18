class TreeNode {
    String levelName;
    TreeNode left;
    TreeNode right;
    Queue stages;

    public TreeNode(String levelName){
        this.levelName = levelName;
        this.left = null;
        this.right = null;
        this.stages = new Queue();
    }
    private TreeNode root;
    public GameTree(){
        root = new TreeNode("Easy");
        root.left = new TreeNode("Medium (kiri)");
        root.right = new TreeNode("Medium (kanan)");
        root.right.right = new TreeNode("Hard");
    }
    public void playLevel(TreeNode node, Scanner scanner){
    if(node == null){
        System.out.println("Level tidak ada.");
        return;
    }
    System.out.println("Level: " + node.levelName);
    int totalScore = 0;
    while (!node.stages.isEmpty()){
        totalScore += node.stages;
    if (node.left  == null && node.right == null){
        System.out.println("Level telah diselesaikan");
        return;
    }
    System.out.println("Pilih level selanjutnya: ");
    if(node.left != null){
        System.out.println("1. " + node.left.levelName);
    }
    if(node.right != null){
        System.out.println("2. " + node.right.levelName);
        }
    }
    }
}
