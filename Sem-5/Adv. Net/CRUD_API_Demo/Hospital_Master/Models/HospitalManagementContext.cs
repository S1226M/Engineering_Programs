using System;
using System.Collections.Generic;
using System.Numerics;
using Microsoft.EntityFrameworkCore;

namespace CRUDAPIDemo.Models;

public partial class HospitalManagementContext : DbContext
{
    public HospitalManagementContext()
    {
    }

    public HospitalManagementContext(DbContextOptions<HospitalManagementContext> options)
        : base(options)
    {
    }

    public virtual DbSet<HospitalMaster> HospitalMasters { get; set; }
    public virtual DbSet<Doctor> Doctors { get; set; }
    public virtual DbSet<Patient> Patients { get; set; }


    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<HospitalMaster>(entity =>
        {
            entity.HasKey(e => e.HospitalId).HasName("PK__Hospital__38C2E58F099D20C0");

            entity.ToTable("HospitalMaster");

            entity.Property(e => e.HospitalId)
                .ValueGeneratedNever()
                .HasColumnName("HospitalID");
            entity.Property(e => e.ContactNumber).HasMaxLength(10);
            entity.Property(e => e.EmailAddress).HasMaxLength(259);
            entity.Property(e => e.HospitalAddress).HasMaxLength(250);
            entity.Property(e => e.HospitalName).HasMaxLength(150);
            entity.Property(e => e.OpeningDate).HasColumnType("datetime");
            entity.Property(e => e.OwnerName).HasMaxLength(250);
        });

        modelBuilder.Entity<Doctor>(entity =>
        {
            entity.HasKey(e => e.DoctorId);

            entity.ToTable("Doctor");

            entity.Property(e => e.DoctorId).HasColumnName("DoctorID");
            entity.Property(e => e.DoctorName).HasMaxLength(100);
            entity.Property(e => e.Degree).HasMaxLength(100);
            entity.Property(e => e.Experience).HasMaxLength(100);
            entity.Property(e => e.Specialization).HasMaxLength(100);
            entity.Property(e => e.Age);
            entity.Property(e => e.Dob).HasColumnName("DOB").HasColumnType("datetime");
        });

        modelBuilder.Entity<Patient>(entity =>
        {
            entity.HasKey(e => e.PatientId);

            entity.ToTable("Patient");

            entity.Property(e => e.PatientId).HasColumnName("PatientID");
            entity.Property(e => e.PatientName).HasMaxLength(100);
            entity.Property(e => e.ContactNumber).HasMaxLength(100);
            entity.Property(e => e.Age);
            entity.Property(e => e.EarlierOperation);
            entity.Property(e => e.BloodGroup).HasMaxLength(10);
        });

        OnModelCreatingPartial(modelBuilder);
    }


    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}
