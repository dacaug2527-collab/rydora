using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;
using Pomelo.EntityFrameworkCore.MySql.Scaffolding.Internal;

namespace adminservice.Models;

public partial class P27RydoraContext : DbContext
{
    public P27RydoraContext()
    {
    }

    public P27RydoraContext(DbContextOptions<P27RydoraContext> options)
        : base(options)
    {
    }

    public virtual DbSet<Booking> Bookings { get; set; }

    public virtual DbSet<DriverInfo> DriverInfos { get; set; }

    public virtual DbSet<FareRate> FareRates { get; set; }

    public virtual DbSet<Feedback> Feedbacks { get; set; }

    public virtual DbSet<Payment> Payments { get; set; }

    public virtual DbSet<Role> Roles { get; set; }

    public virtual DbSet<User> Users { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see https://go.microsoft.com/fwlink/?LinkId=723263.
        => optionsBuilder.UseMySql("server=localhost;port=3306;user=root;password=root;database=p27_rydora", Microsoft.EntityFrameworkCore.ServerVersion.Parse("8.2.0-mysql"));

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder
            .UseCollation("utf8mb4_0900_ai_ci")
            .HasCharSet("utf8mb4");

        modelBuilder.Entity<Booking>(entity =>
        {
            entity.HasKey(e => e.BookingId).HasName("PRIMARY");

            entity.ToTable("booking");

            entity.HasIndex(e => e.DriverId, "driver_id_idx");

            entity.HasIndex(e => e.UserId1, "user_id_idx");

            entity.Property(e => e.BookingId).HasColumnName("booking_id");
            entity.Property(e => e.BookingDatetime)
                .HasColumnType("datetime")
                .HasColumnName("booking_datetime");
            entity.Property(e => e.BookingStatus)
                .HasColumnType("enum('PENDING','ACCEPTED','REJECTED','CANCELLED','COMPLETED')")
                .HasColumnName("booking_status");
            entity.Property(e => e.DriverId).HasColumnName("driver_id");
            entity.Property(e => e.EndLocation)
                .HasMaxLength(255)
                .HasColumnName("end_location");
            entity.Property(e => e.Km).HasColumnName("km");
            entity.Property(e => e.StartLocation)
                .HasMaxLength(255)
                .HasColumnName("start_location");
            entity.Property(e => e.UserId1).HasColumnName("user_id1");

            entity.HasOne(d => d.Driver).WithMany(p => p.Bookings)
                .HasForeignKey(d => d.DriverId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("driver_id");

            entity.HasOne(d => d.UserId1Navigation).WithMany(p => p.Bookings)
                .HasForeignKey(d => d.UserId1)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("user_id1");
        });

        modelBuilder.Entity<DriverInfo>(entity =>
        {
            entity.HasKey(e => e.DriverId).HasName("PRIMARY");

            entity.ToTable("driver_info");

            entity.HasIndex(e => e.UserId, "user_id_idx");

            entity.Property(e => e.DriverId).HasColumnName("driver_id");
            entity.Property(e => e.AccountNo).HasColumnName("account_no");
            entity.Property(e => e.DriverLicensePath)
                .HasMaxLength(255)
                .HasColumnName("driver_license_path");
            entity.Property(e => e.DrivingLicense)
                .HasMaxLength(25)
                .HasColumnName("driving_license");
            entity.Property(e => e.PanCard)
                .HasMaxLength(20)
                .HasColumnName("pan_card");
            entity.Property(e => e.UserId).HasColumnName("user_id");

            entity.HasOne(d => d.User).WithMany(p => p.DriverInfos)
                .HasForeignKey(d => d.UserId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("user_id");
        });

        modelBuilder.Entity<FareRate>(entity =>
        {
            entity.HasKey(e => e.FareId).HasName("PRIMARY");

            entity.ToTable("fare_rate");

            entity.Property(e => e.FareId).HasColumnName("fare_id");
            entity.Property(e => e.BaseFare).HasColumnName("base_fare");
            entity.Property(e => e.ExtraAllowance).HasColumnName("extra_allowance");
            entity.Property(e => e.PerKmRate).HasColumnName("per_km_rate");
            entity.Property(e => e.UpdateAt)
                .HasColumnType("datetime")
                .HasColumnName("update_at");
        });

        modelBuilder.Entity<Feedback>(entity =>
        {
            entity.HasKey(e => e.FeedbackId).HasName("PRIMARY");

            entity.ToTable("feedback");

            entity.HasIndex(e => e.FeedbackBookingId, "feedback_booking_id_idx");

            entity.HasIndex(e => e.FeedbackDriverid, "feedback_driverid_idx");

            entity.HasIndex(e => e.FeedbackUserid, "feedback_userid_idx");

            entity.Property(e => e.FeedbackId).HasColumnName("feedback_id");
            entity.Property(e => e.FeedbackBookingId).HasColumnName("feedback_booking_id");
            entity.Property(e => e.FeedbackDetails)
                .HasMaxLength(255)
                .HasColumnName("feedback_details");
            entity.Property(e => e.FeedbackDriverid).HasColumnName("feedback_driverid");
            entity.Property(e => e.FeedbackUserid).HasColumnName("feedback_userid");
            entity.Property(e => e.Rating).HasColumnName("rating");

            entity.HasOne(d => d.FeedbackBooking).WithMany(p => p.Feedbacks)
                .HasForeignKey(d => d.FeedbackBookingId)
                .HasConstraintName("feedback_booking_id");

            entity.HasOne(d => d.FeedbackDriver).WithMany(p => p.Feedbacks)
                .HasForeignKey(d => d.FeedbackDriverid)
                .HasConstraintName("feedback_driverid");

            entity.HasOne(d => d.FeedbackUser).WithMany(p => p.Feedbacks)
                .HasForeignKey(d => d.FeedbackUserid)
                .HasConstraintName("feedback_userid");
        });

        modelBuilder.Entity<Payment>(entity =>
        {
            entity.HasKey(e => e.PaymentId).HasName("PRIMARY");

            entity.ToTable("payment");

            entity.Property(e => e.PaymentId).HasColumnName("payment_id");
            entity.Property(e => e.Amount).HasColumnName("amount");
            entity.Property(e => e.BookingId).HasColumnName("booking_id");
            entity.Property(e => e.DateTime)
                .HasColumnType("datetime")
                .HasColumnName("date_time");
            entity.Property(e => e.PaymentMethod)
                .HasColumnType("enum('CARD','UPI','CASH')")
                .HasColumnName("payment_method");
            entity.Property(e => e.PaymentStatus)
                .HasColumnType("enum('SUCESS','FAILED','PENDING')")
                .HasColumnName("payment_status");
            entity.Property(e => e.TransactionId)
                .HasMaxLength(255)
                .HasColumnName("transaction_id");
        });

        modelBuilder.Entity<Role>(entity =>
        {
            entity.HasKey(e => e.RoleId).HasName("PRIMARY");

            entity.ToTable("role");

            entity.Property(e => e.RoleId).HasColumnName("role_id");
            entity.Property(e => e.RoleName)
                .HasMaxLength(10)
                .HasColumnName("role_name");
        });

        modelBuilder.Entity<User>(entity =>
        {
            entity.HasKey(e => e.UserId).HasName("PRIMARY");

            entity.ToTable("user");

            entity.HasIndex(e => e.RoleId, "role_id_idx");

            entity.HasIndex(e => e.UserName, "user_name_UNIQUE").IsUnique();

            entity.Property(e => e.UserId).HasColumnName("user_id");
            entity.Property(e => e.Aadhar)
                .HasMaxLength(12)
                .HasColumnName("aadhar");
            entity.Property(e => e.AadharImgPath)
                .HasMaxLength(255)
                .HasColumnName("aadhar_img_path");
            entity.Property(e => e.ContactNo)
                .HasMaxLength(10)
                .HasColumnName("contact_no");
            entity.Property(e => e.CurrentAddress)
                .HasMaxLength(100)
                .HasColumnName("current_address");
            entity.Property(e => e.Email)
                .HasMaxLength(50)
                .HasColumnName("email");
            entity.Property(e => e.FirstName)
                .HasMaxLength(20)
                .HasColumnName("first_name");
            entity.Property(e => e.LastName)
                .HasMaxLength(20)
                .HasColumnName("last_name");
            entity.Property(e => e.Password)
                .HasMaxLength(255)
                .HasColumnName("password");
            entity.Property(e => e.PermanentAddress)
                .HasMaxLength(100)
                .HasColumnName("permanent_address");
            entity.Property(e => e.RoleId).HasColumnName("role_id");
            entity.Property(e => e.UserName)
                .HasMaxLength(50)
                .HasColumnName("user_name");

            entity.HasOne(d => d.Role).WithMany(p => p.Users)
                .HasForeignKey(d => d.RoleId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("role_id");
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}
