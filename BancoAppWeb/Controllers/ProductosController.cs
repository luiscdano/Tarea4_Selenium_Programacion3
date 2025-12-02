using Microsoft.AspNetCore.Mvc;
using BancoAppWeb.Models;
using System.Collections.Generic;

namespace BancoAppWeb.Controllers
{
    public class ProductosController : Controller
    {
        public IActionResult Index()
        {
            var productos = new List<Producto>
            {
                new Producto { Id = 1, Nombre = "Cuenta de Ahorros", Descripcion = "Ideal para guardar y hacer crecer tu dinero.", ImagenUrl = "/images/ahorros.png", TasaInteres = 2.5M },
                new Producto { Id = 2, Nombre = "Cuenta Corriente", Descripcion = "Perfecta para manejar tu dinero con flexibilidad.", ImagenUrl = "/images/corriente.png", TasaInteres = 0 },
                new Producto { Id = 3, Nombre = "Tarjeta de Crédito", Descripcion = "Financia tus compras con beneficios exclusivos.", ImagenUrl = "/images/tarjeta.png", TasaInteres = 12.99M },
                new Producto { Id = 4, Nombre = "Préstamo Personal", Descripcion = "Obtén el préstamo ideal para tus metas.", ImagenUrl = "/images/prestamo.png", TasaInteres = 8.75M }
            };

            return View(productos);
        }
    }
} 