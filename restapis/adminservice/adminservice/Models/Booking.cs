using System;
using System.Collections.Generic;

namespace adminservice.Models;

public partial class Booking
{
    public int BookingId { get; set; }

    public string StartLocation { get; set; } = null!;

    public string EndLocation { get; set; } = null!;

    public DateTime BookingDatetime { get; set; }

    public string BookingStatus { get; set; } = null!;

    public int UserId1 { get; set; }

    public int DriverId { get; set; }

    public float Km { get; set; }

    public virtual DriverInfo Driver { get; set; } = null!;

    public virtual ICollection<Feedback> Feedbacks { get; set; } = new List<Feedback>();

    public virtual User UserId1Navigation { get; set; } = null!;
}
