using System;
using System.Collections.Generic;

namespace adminservice.Models;

public partial class User
{
    public int UserId { get; set; }

    public string UserName { get; set; } = null!;

    public string Password { get; set; } = null!;

    public string Email { get; set; } = null!;

    public string ContactNo { get; set; } = null!;

    public string PermanentAddress { get; set; } = null!;

    public string CurrentAddress { get; set; } = null!;

    public string FirstName { get; set; } = null!;

    public string LastName { get; set; } = null!;

    public string Aadhar { get; set; } = null!;

    public string AadharImgPath { get; set; } = null!;

    public int RoleId { get; set; }

    public virtual ICollection<Booking> Bookings { get; set; } = new List<Booking>();

    public virtual ICollection<DriverInfo> DriverInfos { get; set; } = new List<DriverInfo>();

    public virtual ICollection<Feedback> Feedbacks { get; set; } = new List<Feedback>();

    public virtual Role Role { get; set; } = null!;
}
