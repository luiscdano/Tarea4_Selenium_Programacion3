namespace BancoAppWeb.Models
{
    public class Divisa
    {
        public string Nombre { get; set; }
        public string Codigo { get; set; }
        public decimal Venta { get; set; }
        public decimal Compra { get; set; }
        public string IconoBandera { get; set; } // URL o ícono
    }
} 