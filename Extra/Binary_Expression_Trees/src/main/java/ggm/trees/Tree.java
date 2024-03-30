package ggm.trees;

import java.util.ArrayList;
import java.util.List;

public class Tree<E> {
    
    private TreeNode<E> root;
    
    public Tree () {
        this.root = null; 
    }
    
    public boolean isEmpty () {
        return this.root == null;
    }

    public E getRoot() {
        return root.getContent();
    }
    
    private TreeNode getRootNode () {
        return this.root;
    }

    private void setRootNode(TreeNode<E> root) {
        this.root = root;
    }
    
    public void setRoot (E content) {
    if (this.root == null) {
        this.root = new TreeNode<>(content);  // Asumiendo que tienes un constructor en TreeNode que acepta un contenido
    } else {
        this.root.setContent(content);
    }
}

    
    public boolean isLeaf () {
        return this.root.getChildren().isEmpty();
    }
    
   public void getCaminoMasCostoso() {
        ResultadoCamino resultado = new ResultadoCamino();
        getCaminoMasCostoso(this.root, resultado, new ArrayList<E>(), 0);
        System.out.println("Camino más costoso: " + resultado.camino);
        System.out.println("Costo del camino: " + resultado.costo);
    }

    private void getCaminoMasCostoso(TreeNode<E> node, ResultadoCamino resultado, List<E> caminoActual, int costoActual) {
        if (node == null) return;

        caminoActual.add(node.getContent());
        costoActual += node.getContent(); // Aquí ya no es necesario .intValue()

        if (node.getChildren().isEmpty()) { // es una hoja
            if (costoActual > resultado.costo) {
                resultado.costo = costoActual;
                resultado.camino = new ArrayList<>(caminoActual);
            }
        } else {
            for (TreeNode<E> child : node.getChildren()) {
                getCaminoMasCostoso(child, resultado, caminoActual, costoActual);
            }
        }

        caminoActual.remove(caminoActual.size() - 1);
    }

    private static class ResultadoCamino {
        List<Integer> camino;
        int costo;

        public ResultadoCamino() {
            this.camino = new ArrayList<>();
            this.costo = 0;
        }
    }
    /*
    public int countNodes() {
        if (this.root == null) {
            return 0;
        }

        int count = 1;

        if (this.isLeaf()) {
            return 1;
        }

        for (Tree child : this.getChildrens()) {
            count += child.countNodes();
        }

        return count;
    }

    
    
    
    */

}
public class Tree<E extends Integer> {
    
    private TreeNode<E> root;
    
    // ... (otros métodos y constructores)

    public void getCaminoMasCostoso() {
        List<E> caminoMasCostoso = new ArrayList<>();
        int costoMasAlto = 0;

        List<E> resultadoCamino = new ArrayList<>();
        int resultadoCosto = getCaminoMasCostoso(this.root, resultadoCamino, 0, caminoMasCostoso, costoMasAlto);

        System.out.println("Camino más costoso: " + caminoMasCostoso);
        System.out.println("Costo del camino: " + resultadoCosto);
    }

    private int getCaminoMasCostoso(TreeNode<E> node, List<E> caminoActual, int costoActual, List<E> caminoMasCostoso, int costoMasAlto) {
        if (node == null) return costoMasAlto;

        caminoActual.add(node.getContent());
        costoActual += node.getContent();

        if (node.getChildren().isEmpty()) {
            if (costoActual > costoMasAlto) {
                costoMasAlto = costoActual;
                caminoMasCostoso.clear();
                caminoMasCostoso.addAll(caminoActual);
            }
        } else {
            for (TreeNode<E> child : node.getChildren()) {
                costoMasAlto = getCaminoMasCostoso(child, caminoActual, costoActual, caminoMasCostoso, costoMasAlto);
            }
        }

        caminoActual.remove(caminoActual.size() - 1);
        return costoMasAlto;
    }

    // ... (otros métodos)
}
