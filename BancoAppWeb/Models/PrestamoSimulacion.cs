using System.ComponentModel.DataAnnotations;

namespace BancoAppWeb.Models
{
    public class PrestamoSimulacion
    {
        [Required]
        [Range(10000, 5000000, ErrorMessage = "El monto debe estar entre 10,000 y 5,000,000 RD$")]
        public decimal Monto { get; set; }

        [Required]
        [Range(6, 240, ErrorMessage = "El plazo debe estar entre 6 y 240 meses.")]
        public int PlazoMeses { get; set; }

        [Required]
        [Range(1, 30, ErrorMessage = "La tasa debe estar entre 1% y 30%")]
        public decimal TasaInteresAnual { get; set; }

        public decimal CuotaMensual { get; set; }
        public decimal TotalPagar { get; set; }
    }
} 