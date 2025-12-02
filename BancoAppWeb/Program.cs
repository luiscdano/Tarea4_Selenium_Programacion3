using Microsoft.AspNetCore.Identity;
using Microsoft.EntityFrameworkCore;
using BancoAppWeb.Data;
using BancoAppWeb.Services;

var builder = WebApplication.CreateBuilder(args);

// ----------------------------------------
// CONFIGURACIÓN DE SERVICIOS
// ----------------------------------------

// Base de datos SQLite
builder.Services.AddDbContext<ApplicationDbContext>(options =>
    options.UseSqlite(builder.Configuration.GetConnectionString("DefaultConnection")));

// Identity con roles y autenticación
builder.Services.AddDefaultIdentity<IdentityUser>(options =>
{
    options.SignIn.RequireConfirmedAccount = false;
    options.Password.RequireDigit = false;
    options.Password.RequireLowercase = false;
    options.Password.RequireUppercase = false;
    options.Password.RequireNonAlphanumeric = false;
    options.Password.RequiredLength = 6;
})
.AddRoles<IdentityRole>()
.AddEntityFrameworkStores<ApplicationDbContext>();

// MVC - Controladores con Vistas
builder.Services.AddControllersWithViews();

// Activar HttpClient (necesario para API de divisas)
builder.Services.AddHttpClient();

// Razor Pages para Login/Registro
builder.Services.AddRazorPages();

var app = builder.Build();

// ----------------------------------------
// CONFIGURACIÓN DEL PIPELINE
// ----------------------------------------
if (!app.Environment.IsDevelopment())
{
    app.UseExceptionHandler("/Home/Error");
    app.UseHsts();
}

app.UseHttpsRedirection();
app.UseStaticFiles(); // Soporta CSS, JS, imágenes

app.UseRouting();

// Seguridad
app.UseAuthentication();
app.UseAuthorization();

// ----------------------------------------
// RUTAS MVC y Razor
// ----------------------------------------
app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Home}/{action=Index}/{id?}");

app.MapRazorPages(); // Login / Register / Manage

// ----------------------------------------
// INICIALIZAR DATOS NECESARIOS PARA LOS TESTS
// ----------------------------------------
using (var scope = app.Services.CreateScope())
{
    var services = scope.ServiceProvider;
    await DatabaseSeeder.SeedAsync(services);
}

app.Run();
