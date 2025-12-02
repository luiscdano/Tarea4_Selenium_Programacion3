using Newtonsoft.Json;

namespace BancoAppWeb.Models
{
    public class RootDivisasBC
    {
        [JsonProperty("tasas_de_cambio")]
        public List<DivisaBC> tasas_de_cambio { get; set; }
    }

    public class DivisaBC
    {
        public string moneda { get; set; }
        public string descripcion { get; set; }
        public decimal compra { get; set; }
        public decimal venta { get; set; }
    }
} 