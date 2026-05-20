// Tienda.cs
// Tienda con inventario simple en C#
// Conceptos: interface, clase, propiedades, métodos

using System;

// INTERFACE: contrato que todo producto debe cumplir
interface IProducto {
    bool Vender(int unidades);
    void AgregarStock(int unidades);
    void Mostrar();
}

// CLASE que implementa la interface
class Producto : IProducto {
    // PROPIEDADES de solo lectura desde afuera
    public string Nombre   { get; private set; }
    public double Precio   { get; private set; }
    public int    Cantidad { get; private set; }

    // CONSTRUCTOR
    public Producto(string nombre, double precio, int cantidad) {
        Nombre   = nombre;
        Precio   = precio;
        Cantidad = cantidad;
    }

    public bool Vender(int unidades) {
        if (unidades > Cantidad) {
            Console.WriteLine($"Stock insuficiente. Solo hay {Cantidad} unidades.");
            return false;
        }
        Cantidad -= unidades;
        Console.WriteLine($"Venta de {unidades} x {Nombre} = ${Precio * unidades}");
        return true;
    }

    public void AgregarStock(int unidades) {
        Cantidad += unidades;
        Console.WriteLine($"Stock actualizado: +{unidades} {Nombre}");
    }

    public void Mostrar() {
        Console.WriteLine($"Producto : {Nombre}");
        Console.WriteLine($"Precio   : ${Precio}");
        Console.WriteLine($"Stock    : {Cantidad} unidades");
        Console.WriteLine("--------------------");
    }
}

class Program {
    static void Main(string[] args) {
        Producto p1 = new Producto("Cuaderno",  3500.0, 10);
        Producto p2 = new Producto("Lapicero",   800.0, 50);
        Producto p3 = new Producto("Mochila",  45000.0,  5);

        Console.WriteLine("=== INVENTARIO INICIAL ===");
        p1.Mostrar(); p2.Mostrar(); p3.Mostrar();

        Console.WriteLine("=== VENTAS ===");
        p1.Vender(3);
        p2.Vender(10);
        p3.Vender(10); // no hay suficiente stock

        Console.WriteLine("\n=== INVENTARIO FINAL ===");
        p1.Mostrar(); p2.Mostrar(); p3.Mostrar();
    }
}

// EJECUTAR:
// dotnet run
