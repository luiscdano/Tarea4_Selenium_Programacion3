using System.ComponentModel.DataAnnotations;

namespace BancoAppWeb.Models
{
    public class Producto
    {
        public int Id { get; set; }

        [Required]
        public string Nombre { get; set; }

        public string Descripcion { get; set; }

        public string ImagenUrl { get; set; } // Para mostrar iconos/tarjetas

        public decimal TasaInteres { get; set; } // Para préstamos o tarjetas

        public bool Disponible { get; set; } // Mostrar solo activos
    }
} 