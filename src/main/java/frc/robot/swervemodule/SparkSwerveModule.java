package frc.robot.swervemodule;

import org.strykeforce.swerve.SwerveModule;

public class SparkSwerveModule implements SwerveModule {

private final double MAX_SPEED = 5.36;

private final double DRIVE_DEADBAND = 0.536;

private final double WHEEL_CIRCUMFERENCE = 0.0791;

private final double AZIMUTH_COUNTS_PER_REV;
private final double DRIVE_COUNTS_PER_REV;
private final double DRIVE_GEAR_RATIO;

    /**
     * Gets the maximum attainable speed of the drive.
     *
     * @return max speed in meters/sec
     */
    double getMaxSpeedMetersPerSecond();

    /**
     * Provides the wheel location as Translation2d.
     *
     * @return wheel location in meters relative to center of robot
     */
    Translation2d getWheelLocationMeters();

    /**
     * Gets the current state of the swerve module.
     *
     * @return current state of the swerve module
     */
    SwerveModuleState getState();

    /**
     * Command the swerve module motors to the desired state.
     *
     * @param desiredState the desired swerve module speed and angle
     * @param isDriveOpenLoop false if drive should set speed using closed-loop velocity control
     */
    void setDesiredState(SwerveModuleState desiredState, boolean isDriveOpenLoop);

    /**
     * Command the swerve module motors to the desired state using closed-loop drive speed control.
     *
     * @param desiredState the desired swerve module speed and angle
     */
    default void setDesiredState(SwerveModuleState desiredState) {
        this.setDesiredState(desiredState, false);
    }

    /**
     * Command the swerve module azimuth rotation to the desired angle with a drive speed of zero. If
     * setting the module to an angle with a non-zero drive speed, use {@link
     * SwerveModule#setDesiredState(SwerveModuleState)} or {@link
     * SwerveModule#setDesiredState(SwerveModuleState, boolean)}.
     *
     * @param rotation the desired absolute azimuth angle
     */
    void setAzimuthRotation2d(Rotation2d rotation);

    /**
     * Get the angle of the swerve drive azimuth.
     *
     * @return the angle of the azimuth rotation.
     */
    Rotation2d getAzimuthRotation2d();

    /** Resets the drive encoders to currently read a position of 0. */
    void resetDriveEncoder();

    /**
     * Save the current azimuth absolute encoder reference position in NetworkTables preferences. Call
     * this method following physical alignment of the module wheel in its zeroed position. Used
     * during module instantiation to initialize the relative encoder.
     */
    void storeAzimuthZeroReference();

    /**
     * Loads the current azimuth absolute encoder reference position and sets selected sensor encoder.
     */
    void loadAndSetAzimuthZeroReference();

}

