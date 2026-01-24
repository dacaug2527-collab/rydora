using adminservice.DTOs;
using adminservice.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace adminservice.Controllers
{
    [ApiController]
    [Route("api/admin")]
    public class AdminController : Controller
    {
        private readonly P27RydoraContext _dbContext;
        public AdminController(P27RydoraContext dbContext)
        {
            _dbContext = dbContext;
        }

        [HttpPost("login")]
        public IActionResult Login(AdminLoginDto dto)
        {
            var admin = _dbContext.Users.FirstOrDefault(u =>
            u.Email == dto.email && u.Password == dto.password && u.RoleId == 1

                );
            if (admin == null)
                return Unauthorized("Invalid admin credentials");

            return Ok("Admin login successful");


        }

        [HttpGet("users")]
        public IActionResult GetUsers()
        {
            return Ok(_dbContext.Users.Where(u => u.RoleId == 2).ToList()


            );

        }


        [HttpGet("drivers")]
        public IActionResult GetDrivers()
        {
            return Ok(_dbContext.Users.Where(u => u.RoleId == 3).ToList()
                );
        }

        [HttpGet("bookings")]
        public IActionResult GetBookings()
        {
            return Ok(_dbContext.Bookings.ToList()
                );


        }

        [HttpGet("feedback")]
        public IActionResult GetFeedback()
        {
            return Ok(_dbContext.Feedbacks.ToList());


        }

        [HttpGet("transaction")]
        public IActionResult GetTransaction()
        {
            return Ok(_dbContext.Payments.ToList());
        }
    }
}
