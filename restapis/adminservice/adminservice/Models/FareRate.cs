using System;
using System.Collections.Generic;

namespace adminservice.Models;

public partial class FareRate
{
    public int FareId { get; set; }

    public double BaseFare { get; set; }

    public double PerKmRate { get; set; }

    public double ExtraAllowance { get; set; }

    public DateTime UpdateAt { get; set; }
}
