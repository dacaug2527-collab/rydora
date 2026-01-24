using System;
using System.Collections.Generic;

namespace adminservice.Models;

public partial class Payment
{
    public int PaymentId { get; set; }

    public double? Amount { get; set; }

    public string PaymentMethod { get; set; } = null!;

    public DateTime DateTime { get; set; }

    public string? TransactionId { get; set; }

    public int BookingId { get; set; }

    public string? PaymentStatus { get; set; }
}
