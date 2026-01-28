using System;
using System.Collections.Generic;

namespace adminservice.Models;

public partial class Feedback
{
    public int FeedbackId { get; set; }

    public string? FeedbackDetails { get; set; }

    public float? Rating { get; set; }

    public int? FeedbackUserid { get; set; }

    public int? FeedbackBookingId { get; set; }

    public int? FeedbackDriverid { get; set; }

    public virtual Booking? FeedbackBooking { get; set; }

    public virtual DriverInfo? FeedbackDriver { get; set; }

    public virtual User? FeedbackUser { get; set; }
}
