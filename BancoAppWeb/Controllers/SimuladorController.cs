using Microsoft.AspNetCore.Mvc;
using BancoAppWeb.Models;

namespace BancoAppWeb.Controllers
{
    public class SimuladorController : Controller
    {
        [HttpGet]
        public IActionResult Index()
        {
            return View(new PrestamoSimulacion());
        }

        [HttpPost]
        public IActionResult Index(PrestamoSimulacion modelo)
        {
            if (ModelState.IsValid)
            {
                decimal tasaMensual = modelo.TasaInteresAnual / 12 / 100;
                decimal cuota = modelo.Monto * (tasaMensual * (decimal)Math.Pow(1 + (double)tasaMensual, modelo.PlazoMeses))
                                 / ((decimal)Math.Pow(1 + (double)tasaMensual, modelo.PlazoMeses) - 1);

                modelo.CuotaMensual = Math.Round(cuota, 2);
                modelo.TotalPagar = Math.Round(cuota * modelo.PlazoMeses, 2);

                return View("Resultado", modelo);
            }

            return View(modelo);
        }
    }
} 