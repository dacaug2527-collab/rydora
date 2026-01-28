using System;
using System.Collections.Generic;

namespace adminservice.Models;

public partial class DriverInfo
{
    public int DriverId { get; set; }

    public string DrivingLicense { get; set; } = null!;

    public string DriverLicensePath { get; set; } = null!;

    public string? PanCard { get; set; }

    public int AccountNo { get; set; }

    public int UserId { get; set; }

    public virtual ICollection<Booking> Bookings { get; set; } = new List<Booking>();

    public virtual ICollection<Feedback> Feedbacks { get; set; } = new List<Feedback>();

    public virtual User User { get; set; } = null!;
}
