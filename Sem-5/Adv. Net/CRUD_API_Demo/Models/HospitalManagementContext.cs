using System;
using System.Collections.Generic;
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

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}
