using System;
using System.Linq;
using System.Threading.Tasks;
using BancoAppWeb.Data;
using BancoAppWeb.Models;
using Microsoft.AspNetCore.Identity;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.DependencyInjection;

namespace BancoAppWeb.Services
{
    public static class DatabaseSeeder
    {
        private const string DefaultUserEmail = "pedrodavid@hotmail.com";
        private const string DefaultUserPassword = "123456";

        public static async Task SeedAsync(IServiceProvider services)
        {
            Console.WriteLine("[Seeder] Iniciando verificación de base de datos...");

            var context = services.GetRequiredService<ApplicationDbContext>();
            await context.Database.MigrateAsync();
            Console.WriteLine("[Seeder] Migraciones aplicadas.");

            if (!context.Clientes.Any())
            {
                Console.WriteLine("[Seeder] Insertando clientes iniciales...");
                context.Clientes.AddRange(
                    new Cliente
                    {
                        Nombre = "Pedro",
                        Apellido = "Espinal",
                        Telefono = "8091234567",
                        Email = "pedro@bancoapp.com"
                    },
                    new Cliente
                    {
                        Nombre = "María",
                        Apellido = "Gómez",
                        Telefono = "8299876543",
                        Email = "maria@bancoapp.com"
                    },
                    new Cliente
                    {
                        Nombre = "Luis",
                        Apellido = "Cedano",
                        Telefono = "8495550000",
                        Email = "luis@bancoapp.com"
                    }
                );

                await context.SaveChangesAsync();
                Console.WriteLine("[Seeder] Clientes iniciales creados.");
            }

            var userManager = services.GetRequiredService<UserManager<IdentityUser>>();
            var existingUser = await userManager.FindByEmailAsync(DefaultUserEmail);

            if (existingUser == null)
            {
                Console.WriteLine("[Seeder] Creando usuario por defecto...");
                var newUser = new IdentityUser
                {
                    UserName = DefaultUserEmail,
                    Email = DefaultUserEmail,
                    EmailConfirmed = true
                };

                var result = await userManager.CreateAsync(newUser, DefaultUserPassword);
                if (!result.Succeeded)
                {
                    var details = string.Join(", ", result.Errors.Select(e => e.Description));
                    throw new InvalidOperationException($"No fue posible crear el usuario inicial: {details}");
                }
                Console.WriteLine("[Seeder] Usuario por defecto creado.");
            }
            else
            {
                Console.WriteLine("[Seeder] Usuario por defecto ya existe.");
            }
        }
    }
}
