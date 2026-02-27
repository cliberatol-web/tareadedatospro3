import java.util.Scanner;

public class MainTCH {

    // NODO
    static class Nodo {
        int dato;
        Nodo siguiente;

        Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    // Pila
    static class Pila {
        private Nodo cima;

        public void push(int dato) {
            Nodo nuevo = new Nodo(dato);
            nuevo.siguiente = cima;
            cima = nuevo;
        }

        public int pop() {
            if (cima == null) {
                System.out.println("Pila vacía.");
                return -1;
            }
            int dato = cima.dato;
            cima = cima.siguiente;
            return dato;
        }

        public void mostrar() {
            Nodo aux = cima;
            System.out.print("Pila: ");
            while (aux != null) {
                System.out.print(aux.dato + " -> ");
                aux = aux.siguiente;
            }
            System.out.println("null");
        }
    }

    // cola
    static class Cola {
        private Nodo frente;
        private Nodo fin;

        public void enqueue(int dato) {
            Nodo nuevo = new Nodo(dato);
            if (frente == null) {
                frente = fin = nuevo;
            } else {
                fin.siguiente = nuevo;
                fin = nuevo;
            }
        }

        public int dequeue() {
            if (frente == null) {
                System.out.println("Cola vacía.");
                return -1;
            }
            int dato = frente.dato;
            frente = frente.siguiente;
            if (frente == null) {
                fin = null;
            }
            return dato;
        }

        public void mostrar() {
            Nodo aux = frente;
            System.out.print("Cola: ");
            while (aux != null) {
                System.out.print(aux.dato + " -> ");
                aux = aux.siguiente;
            }
            System.out.println("null");
        }
    }

    // Arbolbinario
    static class NodoArbol {
        int dato;
        NodoArbol izquierdo;
        NodoArbol derecho;

        NodoArbol(int dato) {
            this.dato = dato;
        }
    }

    static class ArbolBinario {
        private NodoArbol raiz;
        private Scanner sc;

        ArbolBinario(Scanner sc) {
            this.sc = sc; // usar el mismo scanner del main
        }

        public void crearArbol() {
            System.out.println("\n--- CREANDO ÁRBOL ---");
            System.out.print("Ingrese dato de la raíz: ");
            int dato = sc.nextInt();
            raiz = new NodoArbol(dato);
            agregarHijos(raiz);
        }

        private void agregarHijos(NodoArbol nodo) {

            System.out.println();
            System.out.print("¿Agregar hijo izquierdo a " + nodo.dato + "? (s/n): ");
            char opcion = sc.next().toLowerCase().charAt(0);

            if (opcion == 's') {
                System.out.print("Ingrese dato del hijo izquierdo: ");
                int datoIzq = sc.nextInt();
                nodo.izquierdo = new NodoArbol(datoIzq);
                agregarHijos(nodo.izquierdo);
            }

            System.out.println();
            System.out.print("¿Agregar hijo derecho a " + nodo.dato + "? (s/n): ");
            opcion = sc.next().toLowerCase().charAt(0);

            if (opcion == 's') {
                System.out.print("Ingrese dato del hijo derecho: ");
                int datoDer = sc.nextInt();
                nodo.derecho = new NodoArbol(datoDer);
                agregarHijos(nodo.derecho);
            }
        }

        private void preorden(NodoArbol nodo) {
            if (nodo != null) {
                System.out.print(nodo.dato + " ");
                preorden(nodo.izquierdo);
                preorden(nodo.derecho);
            }
        }

        public void mostrarPreorden() {
            System.out.print("Recorrido Preorden: ");
            preorden(raiz);
            System.out.println();
        }
    }

    // main
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Pila pila = new Pila();
        Cola cola = new Cola();
        ArbolBinario arbol = new ArbolBinario(sc);

        int opcion;

        do {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Push Pila");
            System.out.println("2. Pop Pila");
            System.out.println("3. Enqueue Cola");
            System.out.println("4. Dequeue Cola");
            System.out.println("5. Crear Árbol");
            System.out.println("6. Mostrar Árbol (Preorden)");
            System.out.println("7. Salir");
            System.out.print("Seleccione opción: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese número: ");
                    pila.push(sc.nextInt());
                    pila.mostrar();
                    break;

                case 2:
                    System.out.println("Elemento eliminado: " + pila.pop());
                    pila.mostrar();
                    break;

                case 3:
                    System.out.print("Ingrese número: ");
                    cola.enqueue(sc.nextInt());
                    cola.mostrar();
                    break;

                case 4:
                    System.out.println("Elemento eliminado: " + cola.dequeue());
                    cola.mostrar();
                    break;

                case 5:
                    arbol.crearArbol();
                    break;

                case 6:
                    arbol.mostrarPreorden();
                    break;

                case 7:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 7);

        sc.close();
    }
}