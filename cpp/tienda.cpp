
#include <iostream>
#include <string>
using namespace std;

// CLASE: representa un producto en la tienda
class Producto {
private:
    string nombre;
    double precio;
    int    cantidad;

public:
    // CONSTRUCTOR
    Producto(string nombre, double precio, int cantidad) {
        this->nombre   = nombre;
        this->precio   = precio;
        this->cantidad = cantidad;
    }

    // MÉTODO: vender una unidad
    bool vender(int unidades) {
        if (unidades > cantidad) {
            cout << "Stock insuficiente. Solo hay " << cantidad << " unidades." << endl;
            return false;
        }
        cantidad -= unidades;
        cout << "Venta de " << unidades << " x " << nombre
             << " = $" << precio * unidades << endl;
        return true;
    }

    // MÉTODO: agregar stock
    void agregar_stock(int unidades) {
        cantidad += unidades;
        cout << "Stock actualizado: +" << unidades << " " << nombre << endl;
    }

    // MÉTODO: mostrar información
    void mostrar() {
        cout << "Producto : " << nombre   << endl;
        cout << "Precio   : $" << precio  << endl;
        cout << "Stock    : " << cantidad << " unidades" << endl;
        cout << "--------------------" << endl;
    }
};

int main() {
    Producto p1("Cuaderno",   3500.0, 10);
    Producto p2("Lapicero",    800.0, 50);
    Producto p3("Mochila",   45000.0,  5);

    cout << "=== INVENTARIO INICIAL ===" << endl;
    p1.mostrar();
    p2.mostrar();
    p3.mostrar();

    cout << "=== VENTAS ===" << endl;
    p1.vender(3);
    p2.vender(10);
    p3.vender(10); // no hay suficiente stock

    cout << endl << "=== INVENTARIO FINAL ===" << endl;
    p1.mostrar();
    p2.mostrar();
    p3.mostrar();

    return 0;
}


