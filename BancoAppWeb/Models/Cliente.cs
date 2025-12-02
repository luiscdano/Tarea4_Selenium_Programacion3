namespace BancoAppWeb.Models
{
    public class Cliente
    {
        public int Id { get; set; }   // ← Clave primaria obligatoria

        public string Nombre { get; set; } = string.Empty;
        public string Apellido { get; set; } = string.Empty;
        public string Telefono { get; set; } = string.Empty;
        public string Email { get; set; } = string.Empty;
    }
} 