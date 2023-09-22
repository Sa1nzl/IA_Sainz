package binario;
//Clase Arbol
public class Arbol {
    Nodo raiz;

    public Arbol() {
        raiz = null;
    }
    //Metodo Vacio
    public boolean vacio() {
        return raiz == null;
    }

    public Nodo buscarNodo(int valor) {
        return busquedaNODOnew(raiz, valor);
    }
    //Metodo Buscar NODO
    private Nodo busquedaNODOnew(Nodo nodo, int valor) {
        if (nodo == null || nodo.valor == valor) {
            return nodo;
        }
        if (valor < nodo.valor)
            return busquedaNODOnew(nodo.izquierdo, valor);
        else
            return busquedaNODOnew(nodo.derecho, valor);
    }

    public void insertar(int valor) {
        raiz = InsertarNEW(raiz, valor);
    }

    private Nodo InsertarNEW(Nodo nodo, int valor) {
        if (nodo == null) {
            nodo = new Nodo(valor);
            return nodo;
        }
        if (valor < nodo.valor)
            nodo.izquierdo = InsertarNEW(nodo.izquierdo, valor);
        else if (valor > nodo.valor)
            nodo.derecho = InsertarNEW(nodo.derecho, valor);
        return nodo;
    }

    public void imprimirEnOrden() {
        ImprimirenORDENnew(raiz);
    }

    private void ImprimirenORDENnew(Nodo nodo) {
        if (nodo != null) {
            ImprimirenORDENnew(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            ImprimirenORDENnew(nodo.derecho);
        }
    }

    public static void main(String[] args) {
        Arbol arbol = new Arbol();

        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(70);
        arbol.insertar(60);
        arbol.insertar(80);

        System.out.println("Recorrido (En ORDEN) del arbol: ");
        arbol.imprimirEnOrden();

        System.out.println("\n¿El arbol esta vacio? " + arbol.vacio());

        Nodo nodoBuscado = arbol.buscarNodo(70);
        if (nodoBuscado != null) {
            System.out.println("Se encontró el nodo con valor " + nodoBuscado.valor);
        } else {
            System.out.println("No se pudo encontrar el nodo buscado");
        }
    }
}