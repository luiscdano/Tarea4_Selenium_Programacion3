using BancoAppWeb.Models;
using BancoAppWeb.Services;
using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;

namespace BancoAppWeb.Controllers
{
    public class DivisasController : Controller
    {
        public IActionResult Index()
        {
            // Obtener lista desde el servicio
            List<Divisa> divisas = DivisaService.ObtenerDivisas();

            // Retornar la vista con la lista como modelo
            return View(divisas);
        }
    }
} 