using BancoAppWeb.Data;
using BancoAppWeb.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace BancoAppWeb.Controllers
{
    public class ClientesController : Controller
    {
        private readonly ApplicationDbContext _context;

        public ClientesController(ApplicationDbContext context)
        {
            _context = context;
        }

        // GET: /Clientes
        public IActionResult Index()
        {
            var clientes = _context.Clientes.ToList();
            return View(clientes);
        }

        // GET: /Clientes/Create
        public IActionResult Create()
        {
            return View();
        }

        // POST: /Clientes/Create
        [HttpPost]
        public IActionResult Create(Cliente cliente)
        {
            if (ModelState.IsValid)
            {
                _context.Clientes.Add(cliente);
                _context.SaveChanges();
                TempData["SuccessMessage"] = "Cliente registrado correctamente.";
                return RedirectToAction("Index");
            }
            return View(cliente);
        }

        // GET: /Clientes/Edit/5
        public IActionResult Edit(int id)
        {
            var cliente = _context.Clientes.Find(id);
            if (cliente == null)
                return NotFound();

            return View(cliente);
        }

        // POST: /Clientes/Edit/5
        [HttpPost]
        public IActionResult Edit(Cliente cliente)
        {
            if (ModelState.IsValid)
            {
                _context.Clientes.Update(cliente);
                _context.SaveChanges();
                TempData["SuccessMessage"] = "Cliente actualizado correctamente.";
                return RedirectToAction("Index");
            }
            return View(cliente);
        }

        // GET: /Clientes/Delete/5
        public IActionResult Delete(int id)
        {
            var cliente = _context.Clientes.Find(id);
            if (cliente == null)
                return NotFound();

            return View(cliente);
        }

        // POST: /Clientes/Delete/5
        [HttpPost, ActionName("DeleteConfirmed")]
        public IActionResult DeleteConfirmed(int id)
        {
            var cliente = _context.Clientes.Find(id);
            if (cliente == null)
                return NotFound();

            _context.Clientes.Remove(cliente);
            _context.SaveChanges();
            TempData["SuccessMessage"] = "Cliente eliminado correctamente.";

            return RedirectToAction("Index");
        }
    }
} 
