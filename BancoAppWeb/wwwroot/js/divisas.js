let tasaVenta = 0;
let tasaCompra = 0;
let codigo = "";
let chartInstance = null;
let chartGeneral = null;

// ✅ Abrir el modal desde la tarjeta
function abrirModal(nombre, cod, venta, compra) {
    document.getElementById("modalNombre").innerText = `${nombre} (${cod})`;

    tasaVenta = parseFloat(venta);
    tasaCompra = parseFloat(compra);
    codigo = cod;

    // Limpiar campos
    document.getElementById("modalMonto").value = "";
    document.getElementById("modalResultado").style.display = "none";

    // Mostrar modal Bootstrap
    const modalElement = document.getElementById('conversionModal');
    const modal = new bootstrap.Modal(modalElement);
    modal.show();

    // Cargar gráfica del modal
    cargarGraficaModal();
}

// ✅ Cálculo de compra o venta
function calcularConversion() {
    const montoInput = document.getElementById("modalMonto");
    const tipoSelect = document.getElementById("modalTipo");
    const resultadoP = document.getElementById("modalResultado");

    let monto = parseFloat(montoInput.value);
    let tipo = tipoSelect.value;

    if (isNaN(monto) || monto <= 0) {
        resultadoP.style.display = "none";
        return;
    }

    let resultado;

    if (tipo === "venta") {
        // RD$ -> Divisa (usando tasa de venta)
        resultado = monto / tasaVenta;
        resultadoP.innerText =
            `Por RD$ ${monto.toFixed(2)} obtienes ${resultado.toFixed(2)} ${codigo}`;
    } else {
        // Divisa -> RD$ (usando tasa de compra)
        resultado = monto * tasaCompra;
        resultadoP.innerText =
            `${monto.toFixed(2)} ${codigo} equivalen a RD$ ${resultado.toFixed(2)}`;
    }

    resultadoP.style.display = "block";
}

// ✅ Gráfica individual dinámica en el modal
function cargarGraficaModal() {
    const labels = ["01", "05", "10", "15", "20", "25", "30"];

    // Simulación simple alrededor de la tasa de venta
    const data = labels.map(() =>
        (tasaVenta * (0.95 + Math.random() * 0.1)).toFixed(2)
    );

    const canvas = document.getElementById('modalChart');
    if (!canvas) return;

    const ctx = canvas.getContext('2d');

    if (chartInstance) {
        chartInstance.destroy();
    }

    chartInstance = new Chart(ctx, {
        type: 'line',
        data: {
            labels: labels,
            datasets: [{
                label: `Histórico ${codigo}`,
                data: data,
                borderWidth: 2,
                tension: 0.4
            }]
        },
        options: {
            responsive: true,
            plugins: { legend: { display: false } }
        }
    });
}

// ✅ Gráfica general de tendencia simulada (canvas grande)
document.addEventListener("DOMContentLoaded", function () {
    const canvas = document.getElementById("divisaChart");
    if (!canvas) return;

    const ctx = canvas.getContext("2d");

    const labels = ["Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago"];
    const data = labels.map((_, i) => (60 + i * 0.7 + Math.random() * 2).toFixed(2));

    chartGeneral = new Chart(ctx, {
        type: "line",
        data: {
            labels: labels,
            datasets: [{
                label: "Tendencia simulada RD$/USD",
                data: data,
                borderWidth: 2,
                tension: 0.4
            }]
        },
        options: {
            responsive: true,
            plugins: { legend: { display: false } }
        }
    });
}); 