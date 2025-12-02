using BancoAppWeb.Models;
using System.Collections.Generic;

namespace BancoAppWeb.Services
{
    public static class DivisaService
    {
        public static List<Divisa> ObtenerDivisas()
        {
            return new List<Divisa>
            {
                new Divisa { Nombre="Dólar estadounidense", Codigo="USD", Venta=62.46m, Compra=60.46m, IconoBandera="usd.png" },
                new Divisa { Nombre="Euro", Codigo="EUR", Venta=72.45m, Compra=70.45m, IconoBandera="eur.png" },
                new Divisa { Nombre="Libra esterlina", Codigo="GBP", Venta=82.78m, Compra=80.78m, IconoBandera="gbp.png" },
                new Divisa { Nombre="Dólar canadiense", Codigo="CAD", Venta=44.66m, Compra=42.66m, IconoBandera="cad.png" },
                new Divisa { Nombre="Franco suizo", Codigo="CHF", Venta=77.76m, Compra=75.76m, IconoBandera="chf.png" },
                new Divisa { Nombre="Yen japonés", Codigo="JPY", Venta=0.40m, Compra=0.38m, IconoBandera="jpy.png" },
                new Divisa { Nombre="Yuan chino", Codigo="CNY", Venta=8.67m, Compra=6.67m, IconoBandera="cny.png" },
                new Divisa { Nombre="Peso mexicano", Codigo="MXN", Venta=3.62m, Compra=1.62m, IconoBandera="mxn.png" },
                new Divisa { Nombre="Peso argentino", Codigo="ARS", Venta=0.07m, Compra=0.05m, IconoBandera="ars.png" },
                new Divisa { Nombre="Peso chileno", Codigo="CLP", Venta=0.065m, Compra=0.045m, IconoBandera="clp.png" },
                new Divisa { Nombre="Peso colombiano", Codigo="COP", Venta=0.015m, Compra=0.013m, IconoBandera="cop.png" },
                new Divisa { Nombre="Corona noruega", Codigo="NOK", Venta=5.37m, Compra=3.37m, IconoBandera="nok.png" },
                new Divisa { Nombre="Corona sueca", Codigo="SEK", Venta=5.74m, Compra=3.74m, IconoBandera="sek.png" },
                new Divisa { Nombre="Rupia india", Codigo="INR", Venta=0.75m, Compra=0.55m, IconoBandera="inr.png" },
                new Divisa { Nombre="Rublo ruso", Codigo="RUB", Venta=0.68m, Compra=0.48m, IconoBandera="rub.png" },
                new Divisa { Nombre="Oro (onza troy)", Codigo="XAU", Venta=3738.00m, Compra=3718.00m, IconoBandera="xau.png" },
            };
        }
    }
} 