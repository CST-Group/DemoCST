package remoteapi.zmq;

import java.util.*;

import co.nstant.in.cbor.*;

public class RemoteAPIObjects
{
    private final RemoteAPIClient client;

    public RemoteAPIObjects(RemoteAPIClient client)
    {
        this.client = client;
    }

    public class _sim extends remoteapi.zmq.objects.special._sim
    {
        public _sim(RemoteAPIClient client)
        {
            super(client);
        }

        public void acquireLock(Object... args) throws CborException
        {
            this.client.call("sim.acquireLock", args);
        }

        public Long addDrawingObject(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.addDrawingObject", args);
            return ((Long)rets[0]);
        }

        public Long addDrawingObjectItem(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.addDrawingObjectItem", args);
            return ((Long)rets[0]);
        }

        public void addForce(Object... args) throws CborException
        {
            this.client.call("sim.addForce", args);
        }

        public void addForceAndTorque(Object... args) throws CborException
        {
            this.client.call("sim.addForceAndTorque", args);
        }

        public Long addGraphCurve(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.addGraphCurve", args);
            return ((Long)rets[0]);
        }

        public Long addGraphStream(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.addGraphStream", args);
            return ((Long)rets[0]);
        }

        public void addItemToCollection(Object... args) throws CborException
        {
            this.client.call("sim.addItemToCollection", args);
        }

        public void addLog(Object... args) throws CborException
        {
            this.client.call("sim.addLog", args);
        }

        public Long addParticleObject(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.addParticleObject", args);
            return ((Long)rets[0]);
        }

        public void addParticleObjectItem(Object... args) throws CborException
        {
            this.client.call("sim.addParticleObjectItem", args);
        }

        public void addReferencedHandle(Object... args) throws CborException
        {
            this.client.call("sim.addReferencedHandle", args);
        }

        public Long addScript(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.addScript", args);
            return ((Long)rets[0]);
        }

        public Long adjustView(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.adjustView", args);
            return ((Long)rets[0]);
        }

        public Long alignShapeBB(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.alignShapeBB", args);
            return ((Long)rets[0]);
        }

        public Object[] alphaBetaGammaToYawPitchRoll(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.alphaBetaGammaToYawPitchRoll", args);
            return rets;
        }

        public Long announceSceneContentChange(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.announceSceneContentChange", args);
            return ((Long)rets[0]);
        }

        public void associateScriptWithObject(Object... args) throws CborException
        {
            this.client.call("sim.associateScriptWithObject", args);
        }

        public Long auxiliaryConsoleClose(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.auxiliaryConsoleClose", args);
            return ((Long)rets[0]);
        }

        public Long auxiliaryConsoleOpen(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.auxiliaryConsoleOpen", args);
            return ((Long)rets[0]);
        }

        public Long auxiliaryConsolePrint(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.auxiliaryConsolePrint", args);
            return ((Long)rets[0]);
        }

        public Long auxiliaryConsoleShow(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.auxiliaryConsoleShow", args);
            return ((Long)rets[0]);
        }

        public void broadcastMsg(Object... args) throws CborException
        {
            this.client.call("sim.broadcastMsg", args);
        }

        public List<Double> buildIdentityMatrix(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.buildIdentityMatrix", args);
            return ((List<Double>)rets[0]);
        }

        public List<Double> buildMatrix(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.buildMatrix", args);
            return ((List<Double>)rets[0]);
        }

        public List<Double> buildMatrixQ(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.buildMatrixQ", args);
            return ((List<Double>)rets[0]);
        }

        public List<Double> buildPose(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.buildPose", args);
            return ((List<Double>)rets[0]);
        }

        public Long cameraFitToView(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.cameraFitToView", args);
            return ((Long)rets[0]);
        }

        public List<Map<String, Object>> changeEntityColor(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.changeEntityColor", args);
            return ((List<Map<String, Object>>)rets[0]);
        }

        public Object[] checkCollision(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.checkCollision", args);
            return rets;
        }

        public Object[] checkCollisionEx(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.checkCollisionEx", args);
            return rets;
        }

        public Object[] checkDistance(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.checkDistance", args);
            return rets;
        }

        public Object[] checkOctreePointOccupancy(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.checkOctreePointOccupancy", args);
            return rets;
        }

        public Object[] checkProximitySensor(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.checkProximitySensor", args);
            return rets;
        }

        public Object[] checkProximitySensorEx(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.checkProximitySensorEx", args);
            return rets;
        }

        public Object[] checkProximitySensorEx2(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.checkProximitySensorEx2", args);
            return rets;
        }

        public Object[] checkVisionSensor(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.checkVisionSensor", args);
            return rets;
        }

        public List<Double> checkVisionSensorEx(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.checkVisionSensorEx", args);
            return ((List<Double>)rets[0]);
        }

        public void clearFloatSignal(Object... args) throws CborException
        {
            this.client.call("sim.clearFloatSignal", args);
        }

        public void clearInt32Signal(Object... args) throws CborException
        {
            this.client.call("sim.clearInt32Signal", args);
        }

        public void clearStringSignal(Object... args) throws CborException
        {
            this.client.call("sim.clearStringSignal", args);
        }

        public Long closeScene(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.closeScene", args);
            return ((Long)rets[0]);
        }

        public byte[] combineRgbImages(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.combineRgbImages", args);
            return ((byte[])rets[0]);
        }

        public Long computeMassAndInertia(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.computeMassAndInertia", args);
            return ((Long)rets[0]);
        }

        public Long convexDecompose(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.convexDecompose", args);
            return ((Long)rets[0]);
        }

        public List<Long> copyPasteObjects(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.copyPasteObjects", args);
            return ((List<Long>)rets[0]);
        }

        public List<Object> copyTable(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.copyTable", args);
            return ((List<Object>)rets[0]);
        }

        public Long createCollection(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.createCollection", args);
            return ((Long)rets[0]);
        }

        public Long createDummy(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.createDummy", args);
            return ((Long)rets[0]);
        }

        public Long createForceSensor(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.createForceSensor", args);
            return ((Long)rets[0]);
        }

        public Long createHeightfieldShape(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.createHeightfieldShape", args);
            return ((Long)rets[0]);
        }

        public Long createJoint(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.createJoint", args);
            return ((Long)rets[0]);
        }

        public Long createOctree(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.createOctree", args);
            return ((Long)rets[0]);
        }

        public Long createPath(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.createPath", args);
            return ((Long)rets[0]);
        }

        public Long createPointCloud(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.createPointCloud", args);
            return ((Long)rets[0]);
        }

        public Long createPrimitiveShape(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.createPrimitiveShape", args);
            return ((Long)rets[0]);
        }

        public Long createProximitySensor(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.createProximitySensor", args);
            return ((Long)rets[0]);
        }

        public Long createShape(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.createShape", args);
            return ((Long)rets[0]);
        }

        public Object[] createTexture(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.createTexture", args);
            return rets;
        }

        public Long createVisionSensor(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.createVisionSensor", args);
            return ((Long)rets[0]);
        }

        public void destroyCollection(Object... args) throws CborException
        {
            this.client.call("sim.destroyCollection", args);
        }

        public void destroyGraphCurve(Object... args) throws CborException
        {
            this.client.call("sim.destroyGraphCurve", args);
        }

        public Long duplicateGraphCurveToStatic(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.duplicateGraphCurveToStatic", args);
            return ((Long)rets[0]);
        }

        public Object[] executeScriptString(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.executeScriptString", args);
            return rets;
        }

        public void exportMesh(Object... args) throws CborException
        {
            this.client.call("sim.exportMesh", args);
        }

        public Long floatingViewAdd(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.floatingViewAdd", args);
            return ((Long)rets[0]);
        }

        public Long floatingViewRemove(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.floatingViewRemove", args);
            return ((Long)rets[0]);
        }

        public Long generateShapeFromPath(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.generateShapeFromPath", args);
            return ((Long)rets[0]);
        }

        public Long generateTextShape(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.generateTextShape", args);
            return ((Long)rets[0]);
        }

        public Object[] generateTimeOptimalTrajectory(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.generateTimeOptimalTrajectory", args);
            return rets;
        }

        public List<Double> getAlternateConfigs(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getAlternateConfigs", args);
            return ((List<Double>)rets[0]);
        }

        public List<String> getApiFunc(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getApiFunc", args);
            return ((List<String>)rets[0]);
        }

        public String getApiInfo(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getApiInfo", args);
            return ((String)rets[0]);
        }

        public List<Double> getArrayParam(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getArrayParam", args);
            return ((List<Double>)rets[0]);
        }

        public Double getAutoYieldDelay(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getAutoYieldDelay", args);
            return ((Double)rets[0]);
        }

        public Boolean getBoolParam(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getBoolParam", args);
            return ((Boolean)rets[0]);
        }

        public Double getClosestPosOnPath(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getClosestPosOnPath", args);
            return ((Double)rets[0]);
        }

        public List<Long> getCollectionObjects(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getCollectionObjects", args);
            return ((List<Long>)rets[0]);
        }

        public Double getConfigDistance(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getConfigDistance", args);
            return ((Double)rets[0]);
        }

        public Object[] getContactInfo(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getContactInfo", args);
            return rets;
        }

        public Object[] getDecimatedMesh(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getDecimatedMesh", args);
            return rets;
        }

        public Boolean getEngineBoolParam(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getEngineBoolParam", args);
            return ((Boolean)rets[0]);
        }

        public Double getEngineFloatParam(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getEngineFloatParam", args);
            return ((Double)rets[0]);
        }

        public Long getEngineInt32Param(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getEngineInt32Param", args);
            return ((Long)rets[0]);
        }

        public List<Double> getEulerAnglesFromMatrix(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getEulerAnglesFromMatrix", args);
            return ((List<Double>)rets[0]);
        }

        public Long getExplicitHandling(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getExplicitHandling", args);
            return ((Long)rets[0]);
        }

        public String getExtensionString(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getExtensionString", args);
            return ((String)rets[0]);
        }

        public Double getFloatParam(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getFloatParam", args);
            return ((Double)rets[0]);
        }

        public Double getFloatSignal(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getFloatSignal", args);
            return ((Double)rets[0]);
        }

        public List<Map<String, Object>> getGenesisEvents(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getGenesisEvents", args);
            return ((List<Map<String, Object>>)rets[0]);
        }

        public Object[] getGraphCurve(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getGraphCurve", args);
            return rets;
        }

        public Object[] getGraphInfo(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getGraphInfo", args);
            return rets;
        }

        public Long getInt32Param(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getInt32Param", args);
            return ((Long)rets[0]);
        }

        public Long getInt32Signal(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getInt32Signal", args);
            return ((Long)rets[0]);
        }

        public Long getIsRealTimeSimulation(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getIsRealTimeSimulation", args);
            return ((Long)rets[0]);
        }

        public Object[] getJointDependency(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getJointDependency", args);
            return rets;
        }

        public Double getJointForce(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getJointForce", args);
            return ((Double)rets[0]);
        }

        public Object[] getJointInterval(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getJointInterval", args);
            return rets;
        }

        public Object[] getJointMode(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getJointMode", args);
            return rets;
        }

        public Double getJointPosition(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getJointPosition", args);
            return ((Double)rets[0]);
        }

        public Double getJointTargetForce(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getJointTargetForce", args);
            return ((Double)rets[0]);
        }

        public Double getJointTargetPosition(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getJointTargetPosition", args);
            return ((Double)rets[0]);
        }

        public Double getJointTargetVelocity(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getJointTargetVelocity", args);
            return ((Double)rets[0]);
        }

        public Long getJointType(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getJointType", args);
            return ((Long)rets[0]);
        }

        public Double getJointVelocity(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getJointVelocity", args);
            return ((Double)rets[0]);
        }

        public String getLastInfo(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getLastInfo", args);
            return ((String)rets[0]);
        }

        public Object[] getLightParameters(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getLightParameters", args);
            return rets;
        }

        public Long getLinkDummy(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getLinkDummy", args);
            return ((Long)rets[0]);
        }

        public List<String> getMatchingPersistentDataTags(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getMatchingPersistentDataTags", args);
            return ((List<String>)rets[0]);
        }

        public List<Double> getMatrixInverse(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getMatrixInverse", args);
            return ((List<Double>)rets[0]);
        }

        public Long getModelProperty(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getModelProperty", args);
            return ((Long)rets[0]);
        }

        public Boolean getNamedBoolParam(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getNamedBoolParam", args);
            return ((Boolean)rets[0]);
        }

        public Double getNamedFloatParam(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getNamedFloatParam", args);
            return ((Double)rets[0]);
        }

        public Long getNamedInt32Param(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getNamedInt32Param", args);
            return ((Long)rets[0]);
        }

        public byte[] getNamedStringParam(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getNamedStringParam", args);
            return ((byte[])rets[0]);
        }

        public Long getNavigationMode(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getNavigationMode", args);
            return ((Long)rets[0]);
        }

        public Long getObject(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getObject", args);
            return ((Long)rets[0]);
        }

        public String getObjectAlias(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getObjectAlias", args);
            return ((String)rets[0]);
        }

        public String getObjectAliasRelative(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getObjectAliasRelative", args);
            return ((String)rets[0]);
        }

        public Long getObjectChild(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getObjectChild", args);
            return ((Long)rets[0]);
        }

        public List<Double> getObjectChildPose(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getObjectChildPose", args);
            return ((List<Double>)rets[0]);
        }

        public List<Double> getObjectColor(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getObjectColor", args);
            return ((List<Double>)rets[0]);
        }

        public List<Double> getObjectFloatArrayParam(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getObjectFloatArrayParam", args);
            return ((List<Double>)rets[0]);
        }

        public Double getObjectFloatParam(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getObjectFloatParam", args);
            return ((Double)rets[0]);
        }

        public void getObjectFromUid(Object... args) throws CborException
        {
            this.client.call("sim.getObjectFromUid", args);
        }

        public Long getObjectInt32Param(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getObjectInt32Param", args);
            return ((Long)rets[0]);
        }

        public List<Double> getObjectMatrix(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getObjectMatrix", args);
            return ((List<Double>)rets[0]);
        }

        public List<Double> getObjectOrientation(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getObjectOrientation", args);
            return ((List<Double>)rets[0]);
        }

        public Long getObjectParent(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getObjectParent", args);
            return ((Long)rets[0]);
        }

        public List<Double> getObjectPose(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getObjectPose", args);
            return ((List<Double>)rets[0]);
        }

        public List<Double> getObjectPosition(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getObjectPosition", args);
            return ((List<Double>)rets[0]);
        }

        public Long getObjectProperty(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getObjectProperty", args);
            return ((Long)rets[0]);
        }

        public List<Double> getObjectQuaternion(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getObjectQuaternion", args);
            return ((List<Double>)rets[0]);
        }

        public List<Long> getObjectSel(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getObjectSel", args);
            return ((List<Long>)rets[0]);
        }

        public Double getObjectSizeFactor(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getObjectSizeFactor", args);
            return ((Double)rets[0]);
        }

        public Long getObjectSpecialProperty(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getObjectSpecialProperty", args);
            return ((Long)rets[0]);
        }

        public byte[] getObjectStringParam(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getObjectStringParam", args);
            return ((byte[])rets[0]);
        }

        public Long getObjectType(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getObjectType", args);
            return ((Long)rets[0]);
        }

        public Long getObjectUid(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getObjectUid", args);
            return ((Long)rets[0]);
        }

        public Object[] getObjectVelocity(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getObjectVelocity", args);
            return rets;
        }

        public Long getObjects(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getObjects", args);
            return ((Long)rets[0]);
        }

        public List<Long> getObjectsInTree(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getObjectsInTree", args);
            return ((List<Long>)rets[0]);
        }

        public List<Double> getOctreeVoxels(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getOctreeVoxels", args);
            return ((List<Double>)rets[0]);
        }

        public Long getPage(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getPage", args);
            return ((Long)rets[0]);
        }

        public List<Double> getPathInterpolatedConfig(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getPathInterpolatedConfig", args);
            return ((List<Double>)rets[0]);
        }

        public Object[] getPathLengths(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getPathLengths", args);
            return rets;
        }

        public List<String> getPersistentDataTags(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getPersistentDataTags", args);
            return ((List<String>)rets[0]);
        }

        public String getPluginInfo(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getPluginInfo", args);
            return ((String)rets[0]);
        }

        public String getPluginName(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getPluginName", args);
            return ((String)rets[0]);
        }

        public Object[] getPointCloudOptions(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getPointCloudOptions", args);
            return rets;
        }

        public List<Double> getPointCloudPoints(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getPointCloudPoints", args);
            return ((List<Double>)rets[0]);
        }

        public List<Double> getPoseInverse(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getPoseInverse", args);
            return ((List<Double>)rets[0]);
        }

        public Object[] getQHull(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getQHull", args);
            return rets;
        }

        public List<Double> getQuaternionFromMatrix(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getQuaternionFromMatrix", args);
            return ((List<Double>)rets[0]);
        }

        public Double getRandom(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getRandom", args);
            return ((Double)rets[0]);
        }

        public Boolean getRealTimeSimulation(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getRealTimeSimulation", args);
            return ((Boolean)rets[0]);
        }

        public List<Long> getReferencedHandles(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getReferencedHandles", args);
            return ((List<Long>)rets[0]);
        }

        public Object[] getRotationAxis(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getRotationAxis", args);
            return rets;
        }

        public Object[] getScaledImage(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getScaledImage", args);
            return rets;
        }

        public Long getScript(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getScript", args);
            return ((Long)rets[0]);
        }

        public Map<String, Object> getScriptFunctions(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getScriptFunctions", args);
            return ((Map<String, Object>)rets[0]);
        }

        public Long getScriptInt32Param(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getScriptInt32Param", args);
            return ((Long)rets[0]);
        }

        public byte[] getScriptStringParam(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getScriptStringParam", args);
            return ((byte[])rets[0]);
        }

        public Boolean getSettingBool(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getSettingBool", args);
            return ((Boolean)rets[0]);
        }

        public Double getSettingFloat(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getSettingFloat", args);
            return ((Double)rets[0]);
        }

        public Long getSettingInt32(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getSettingInt32", args);
            return ((Long)rets[0]);
        }

        public String getSettingString(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getSettingString", args);
            return ((String)rets[0]);
        }

        public List<Double> getShapeBB(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getShapeBB", args);
            return ((List<Double>)rets[0]);
        }

        public Object[] getShapeColor(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getShapeColor", args);
            return rets;
        }

        public Object[] getShapeGeomInfo(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getShapeGeomInfo", args);
            return rets;
        }

        public Object[] getShapeInertia(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getShapeInertia", args);
            return rets;
        }

        public Double getShapeMassAndInertia(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getShapeMassAndInertia", args);
            return ((Double)rets[0]);
        }

        public Object[] getShapeMesh(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getShapeMesh", args);
            return rets;
        }

        public Long getShapeTextureId(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getShapeTextureId", args);
            return ((Long)rets[0]);
        }

        public Map<String, Object> getShapeViz(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getShapeViz", args);
            return ((Map<String, Object>)rets[0]);
        }

        public String getSignalName(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getSignalName", args);
            return ((String)rets[0]);
        }

        public Long getSimulationState(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getSimulationState", args);
            return ((Long)rets[0]);
        }

        public Boolean getSimulationStopping(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getSimulationStopping", args);
            return ((Boolean)rets[0]);
        }

        public Double getSimulationTime(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getSimulationTime", args);
            return ((Double)rets[0]);
        }

        public Double getSimulationTimeStep(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getSimulationTimeStep", args);
            return ((Double)rets[0]);
        }

        public Object[] getSimulatorMessage(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getSimulatorMessage", args);
            return rets;
        }

        public String getStackTraceback(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getStackTraceback", args);
            return ((String)rets[0]);
        }

        public String getStringParam(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getStringParam", args);
            return ((String)rets[0]);
        }

        public byte[] getStringSignal(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getStringSignal", args);
            return ((byte[])rets[0]);
        }

        public Double getSystemTime(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getSystemTime", args);
            return ((Double)rets[0]);
        }

        public Object[] getTextureId(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getTextureId", args);
            return rets;
        }

        public Long getThreadId(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getThreadId", args);
            return ((Long)rets[0]);
        }

        public List<String> getUserVariables(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getUserVariables", args);
            return ((List<String>)rets[0]);
        }

        public Object[] getVelocity(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getVelocity", args);
            return rets;
        }

        public Object[] getVisionSensorDepth(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getVisionSensorDepth", args);
            return rets;
        }

        public Object[] getVisionSensorImg(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.getVisionSensorImg", args);
            return rets;
        }

        public void getVisionSensorRes(Object... args) throws CborException
        {
            this.client.call("sim.getVisionSensorRes", args);
        }

        public Long groupShapes(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.groupShapes", args);
            return ((Long)rets[0]);
        }

        public Long handleAddOnScripts(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.handleAddOnScripts", args);
            return ((Long)rets[0]);
        }

        public Long handleChildScripts(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.handleChildScripts", args);
            return ((Long)rets[0]);
        }

        public Long handleDynamics(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.handleDynamics", args);
            return ((Long)rets[0]);
        }

        public Long handleEmbeddedScripts(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.handleEmbeddedScripts", args);
            return ((Long)rets[0]);
        }

        public void handleExtCalls(Object... args) throws CborException
        {
            this.client.call("sim.handleExtCalls", args);
        }

        public void handleGraph(Object... args) throws CborException
        {
            this.client.call("sim.handleGraph", args);
        }

        public void handleJointMotion(Object... args) throws CborException
        {
            this.client.call("sim.handleJointMotion", args);
        }

        public Object[] handleProximitySensor(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.handleProximitySensor", args);
            return rets;
        }

        public void handleSandboxScript(Object... args) throws CborException
        {
            this.client.call("sim.handleSandboxScript", args);
        }

        public void handleSensingStart(Object... args) throws CborException
        {
            this.client.call("sim.handleSensingStart", args);
        }

        public void handleSimulationStart(Object... args) throws CborException
        {
            this.client.call("sim.handleSimulationStart", args);
        }

        public Object[] handleVisionSensor(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.handleVisionSensor", args);
            return rets;
        }

        public Object[] importMesh(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.importMesh", args);
            return rets;
        }

        public Long importShape(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.importShape", args);
            return ((Long)rets[0]);
        }

        public void initScript(Object... args) throws CborException
        {
            this.client.call("sim.initScript", args);
        }

        public Long insertObjectIntoOctree(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.insertObjectIntoOctree", args);
            return ((Long)rets[0]);
        }

        public Long insertObjectIntoPointCloud(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.insertObjectIntoPointCloud", args);
            return ((Long)rets[0]);
        }

        public Long insertPointsIntoPointCloud(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.insertPointsIntoPointCloud", args);
            return ((Long)rets[0]);
        }

        public Long insertVoxelsIntoOctree(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.insertVoxelsIntoOctree", args);
            return ((Long)rets[0]);
        }

        public List<Double> interpolateMatrices(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.interpolateMatrices", args);
            return ((List<Double>)rets[0]);
        }

        public List<Double> interpolatePoses(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.interpolatePoses", args);
            return ((List<Double>)rets[0]);
        }

        public Long intersectPointsWithPointCloud(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.intersectPointsWithPointCloud", args);
            return ((Long)rets[0]);
        }

        public Long isDeprecated(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.isDeprecated", args);
            return ((Long)rets[0]);
        }

        public Boolean isDynamicallyEnabled(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.isDynamicallyEnabled", args);
            return ((Boolean)rets[0]);
        }

        public Boolean isHandle(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.isHandle", args);
            return ((Boolean)rets[0]);
        }

        public void launchExecutable(Object... args) throws CborException
        {
            this.client.call("sim.launchExecutable", args);
        }

        public Object[] loadImage(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.loadImage", args);
            return rets;
        }

        public Long loadModel(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.loadModel", args);
            return ((Long)rets[0]);
        }

        public void loadScene(Object... args) throws CborException
        {
            this.client.call("sim.loadScene", args);
        }

        public List<Double> matrixToPose(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.matrixToPose", args);
            return ((List<Double>)rets[0]);
        }

        public Long moduleEntry(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.moduleEntry", args);
            return ((Long)rets[0]);
        }

        public Object[] moveToConfig(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.moveToConfig", args);
            return rets;
        }

        public Object[] moveToPose(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.moveToPose", args);
            return rets;
        }

        public List<Double> multiplyMatrices(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.multiplyMatrices", args);
            return ((List<Double>)rets[0]);
        }

        public List<Double> multiplyPoses(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.multiplyPoses", args);
            return ((List<Double>)rets[0]);
        }

        public List<Double> multiplyVector(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.multiplyVector", args);
            return ((List<Double>)rets[0]);
        }

        public byte[] packDoubleTable(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.packDoubleTable", args);
            return ((byte[])rets[0]);
        }

        public byte[] packFloatTable(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.packFloatTable", args);
            return ((byte[])rets[0]);
        }

        public byte[] packInt32Table(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.packInt32Table", args);
            return ((byte[])rets[0]);
        }

        public byte[] packTable(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.packTable", args);
            return ((byte[])rets[0]);
        }

        public byte[] packUInt16Table(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.packUInt16Table", args);
            return ((byte[])rets[0]);
        }

        public byte[] packUInt32Table(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.packUInt32Table", args);
            return ((byte[])rets[0]);
        }

        public byte[] packUInt8Table(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.packUInt8Table", args);
            return ((byte[])rets[0]);
        }

        public void pauseSimulation(Object... args) throws CborException
        {
            this.client.call("sim.pauseSimulation", args);
        }

        public byte[] persistentDataRead(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.persistentDataRead", args);
            return ((byte[])rets[0]);
        }

        public void persistentDataWrite(Object... args) throws CborException
        {
            this.client.call("sim.persistentDataWrite", args);
        }

        public List<Double> poseToMatrix(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.poseToMatrix", args);
            return ((List<Double>)rets[0]);
        }

        public void pushUserEvent(Object... args) throws CborException
        {
            this.client.call("sim.pushUserEvent", args);
        }

        public void quitSimulator(Object... args) throws CborException
        {
            this.client.call("sim.quitSimulator", args);
        }

        public byte[] readCustomDataBlock(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.readCustomDataBlock", args);
            return ((byte[])rets[0]);
        }

        public void readCustomDataBlockEx(Object... args) throws CborException
        {
            this.client.call("sim.readCustomDataBlockEx", args);
        }

        public List<String> readCustomDataBlockTags(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.readCustomDataBlockTags", args);
            return ((List<String>)rets[0]);
        }

        public void readCustomTableData(Object... args) throws CborException
        {
            this.client.call("sim.readCustomTableData", args);
        }

        public Object[] readForceSensor(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.readForceSensor", args);
            return rets;
        }

        public Object[] readProximitySensor(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.readProximitySensor", args);
            return rets;
        }

        public byte[] readTexture(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.readTexture", args);
            return ((byte[])rets[0]);
        }

        public Object[] readVisionSensor(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.readVisionSensor", args);
            return rets;
        }

        public Long refreshDialogs(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.refreshDialogs", args);
            return ((Long)rets[0]);
        }

        public void releaseLock(Object... args) throws CborException
        {
            this.client.call("sim.releaseLock", args);
        }

        public Long relocateShapeFrame(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.relocateShapeFrame", args);
            return ((Long)rets[0]);
        }

        public void removeDrawingObject(Object... args) throws CborException
        {
            this.client.call("sim.removeDrawingObject", args);
        }

        public Long removeModel(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.removeModel", args);
            return ((Long)rets[0]);
        }

        public void removeObjects(Object... args) throws CborException
        {
            this.client.call("sim.removeObjects", args);
        }

        public void removeParticleObject(Object... args) throws CborException
        {
            this.client.call("sim.removeParticleObject", args);
        }

        public Long removePointsFromPointCloud(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.removePointsFromPointCloud", args);
            return ((Long)rets[0]);
        }

        public void removeReferencedObjects(Object... args) throws CborException
        {
            this.client.call("sim.removeReferencedObjects", args);
        }

        public void removeScript(Object... args) throws CborException
        {
            this.client.call("sim.removeScript", args);
        }

        public Long removeVoxelsFromOctree(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.removeVoxelsFromOctree", args);
            return ((Long)rets[0]);
        }

        public List<Double> resamplePath(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.resamplePath", args);
            return ((List<Double>)rets[0]);
        }

        public void resetDynamicObject(Object... args) throws CborException
        {
            this.client.call("sim.resetDynamicObject", args);
        }

        public void resetGraph(Object... args) throws CborException
        {
            this.client.call("sim.resetGraph", args);
        }

        public void resetProximitySensor(Object... args) throws CborException
        {
            this.client.call("sim.resetProximitySensor", args);
        }

        public void resetVisionSensor(Object... args) throws CborException
        {
            this.client.call("sim.resetVisionSensor", args);
        }

        public void restoreEntityColor(Object... args) throws CborException
        {
            this.client.call("sim.restoreEntityColor", args);
        }

        public List<Double> rotateAroundAxis(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.rotateAroundAxis", args);
            return ((List<Double>)rets[0]);
        }

        public Long ruckigPos(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.ruckigPos", args);
            return ((Long)rets[0]);
        }

        public void ruckigRemove(Object... args) throws CborException
        {
            this.client.call("sim.ruckigRemove", args);
        }

        public Object[] ruckigStep(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.ruckigStep", args);
            return rets;
        }

        public Long ruckigVel(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.ruckigVel", args);
            return ((Long)rets[0]);
        }

        public byte[] saveImage(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.saveImage", args);
            return ((byte[])rets[0]);
        }

        public void saveModel(Object... args) throws CborException
        {
            this.client.call("sim.saveModel", args);
        }

        public void saveScene(Object... args) throws CborException
        {
            this.client.call("sim.saveScene", args);
        }

        public void scaleObject(Object... args) throws CborException
        {
            this.client.call("sim.scaleObject", args);
        }

        public void scaleObjects(Object... args) throws CborException
        {
            this.client.call("sim.scaleObjects", args);
        }

        public Long serialCheck(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.serialCheck", args);
            return ((Long)rets[0]);
        }

        public void serialClose(Object... args) throws CborException
        {
            this.client.call("sim.serialClose", args);
        }

        public Long serialOpen(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.serialOpen", args);
            return ((Long)rets[0]);
        }

        public byte[] serialRead(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.serialRead", args);
            return ((byte[])rets[0]);
        }

        public Long serialSend(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.serialSend", args);
            return ((Long)rets[0]);
        }

        public void setArrayParam(Object... args) throws CborException
        {
            this.client.call("sim.setArrayParam", args);
        }

        public void setAutoYieldDelay(Object... args) throws CborException
        {
            this.client.call("sim.setAutoYieldDelay", args);
        }

        public void setBoolParam(Object... args) throws CborException
        {
            this.client.call("sim.setBoolParam", args);
        }

        public void setEngineBoolParam(Object... args) throws CborException
        {
            this.client.call("sim.setEngineBoolParam", args);
        }

        public void setEngineFloatParam(Object... args) throws CborException
        {
            this.client.call("sim.setEngineFloatParam", args);
        }

        public void setEngineInt32Param(Object... args) throws CborException
        {
            this.client.call("sim.setEngineInt32Param", args);
        }

        public void setExplicitHandling(Object... args) throws CborException
        {
            this.client.call("sim.setExplicitHandling", args);
        }

        public void setFloatParam(Object... args) throws CborException
        {
            this.client.call("sim.setFloatParam", args);
        }

        public void setFloatSignal(Object... args) throws CborException
        {
            this.client.call("sim.setFloatSignal", args);
        }

        public void setGraphStreamTransformation(Object... args) throws CborException
        {
            this.client.call("sim.setGraphStreamTransformation", args);
        }

        public void setGraphStreamValue(Object... args) throws CborException
        {
            this.client.call("sim.setGraphStreamValue", args);
        }

        public void setInt32Param(Object... args) throws CborException
        {
            this.client.call("sim.setInt32Param", args);
        }

        public void setInt32Signal(Object... args) throws CborException
        {
            this.client.call("sim.setInt32Signal", args);
        }

        public void setJointDependency(Object... args) throws CborException
        {
            this.client.call("sim.setJointDependency", args);
        }

        public void setJointInterval(Object... args) throws CborException
        {
            this.client.call("sim.setJointInterval", args);
        }

        public void setJointMode(Object... args) throws CborException
        {
            this.client.call("sim.setJointMode", args);
        }

        public void setJointPosition(Object... args) throws CborException
        {
            this.client.call("sim.setJointPosition", args);
        }

        public void setJointTargetForce(Object... args) throws CborException
        {
            this.client.call("sim.setJointTargetForce", args);
        }

        public void setJointTargetPosition(Object... args) throws CborException
        {
            this.client.call("sim.setJointTargetPosition", args);
        }

        public void setJointTargetVelocity(Object... args) throws CborException
        {
            this.client.call("sim.setJointTargetVelocity", args);
        }

        public void setLightParameters(Object... args) throws CborException
        {
            this.client.call("sim.setLightParameters", args);
        }

        public void setLinkDummy(Object... args) throws CborException
        {
            this.client.call("sim.setLinkDummy", args);
        }

        public void setModelProperty(Object... args) throws CborException
        {
            this.client.call("sim.setModelProperty", args);
        }

        public void setNamedBoolParam(Object... args) throws CborException
        {
            this.client.call("sim.setNamedBoolParam", args);
        }

        public void setNamedFloatParam(Object... args) throws CborException
        {
            this.client.call("sim.setNamedFloatParam", args);
        }

        public void setNamedInt32Param(Object... args) throws CborException
        {
            this.client.call("sim.setNamedInt32Param", args);
        }

        public void setNamedStringParam(Object... args) throws CborException
        {
            this.client.call("sim.setNamedStringParam", args);
        }

        public void setNavigationMode(Object... args) throws CborException
        {
            this.client.call("sim.setNavigationMode", args);
        }

        public void setObjectAlias(Object... args) throws CborException
        {
            this.client.call("sim.setObjectAlias", args);
        }

        public void setObjectChildPose(Object... args) throws CborException
        {
            this.client.call("sim.setObjectChildPose", args);
        }

        public Boolean setObjectColor(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.setObjectColor", args);
            return ((Boolean)rets[0]);
        }

        public void setObjectFloatArrayParam(Object... args) throws CborException
        {
            this.client.call("sim.setObjectFloatArrayParam", args);
        }

        public void setObjectFloatParam(Object... args) throws CborException
        {
            this.client.call("sim.setObjectFloatParam", args);
        }

        public void setObjectInt32Param(Object... args) throws CborException
        {
            this.client.call("sim.setObjectInt32Param", args);
        }

        public void setObjectMatrix(Object... args) throws CborException
        {
            this.client.call("sim.setObjectMatrix", args);
        }

        public void setObjectOrientation(Object... args) throws CborException
        {
            this.client.call("sim.setObjectOrientation", args);
        }

        public void setObjectParent(Object... args) throws CborException
        {
            this.client.call("sim.setObjectParent", args);
        }

        public void setObjectPose(Object... args) throws CborException
        {
            this.client.call("sim.setObjectPose", args);
        }

        public void setObjectPosition(Object... args) throws CborException
        {
            this.client.call("sim.setObjectPosition", args);
        }

        public void setObjectProperty(Object... args) throws CborException
        {
            this.client.call("sim.setObjectProperty", args);
        }

        public void setObjectQuaternion(Object... args) throws CborException
        {
            this.client.call("sim.setObjectQuaternion", args);
        }

        public void setObjectSel(Object... args) throws CborException
        {
            this.client.call("sim.setObjectSel", args);
        }

        public void setObjectSpecialProperty(Object... args) throws CborException
        {
            this.client.call("sim.setObjectSpecialProperty", args);
        }

        public void setObjectStringParam(Object... args) throws CborException
        {
            this.client.call("sim.setObjectStringParam", args);
        }

        public void setPage(Object... args) throws CborException
        {
            this.client.call("sim.setPage", args);
        }

        public void setPluginInfo(Object... args) throws CborException
        {
            this.client.call("sim.setPluginInfo", args);
        }

        public void setPointCloudOptions(Object... args) throws CborException
        {
            this.client.call("sim.setPointCloudOptions", args);
        }

        public void setReferencedHandles(Object... args) throws CborException
        {
            this.client.call("sim.setReferencedHandles", args);
        }

        public void setScriptInt32Param(Object... args) throws CborException
        {
            this.client.call("sim.setScriptInt32Param", args);
        }

        public void setScriptStringParam(Object... args) throws CborException
        {
            this.client.call("sim.setScriptStringParam", args);
        }

        public void setShapeBB(Object... args) throws CborException
        {
            this.client.call("sim.setShapeBB", args);
        }

        public void setShapeColor(Object... args) throws CborException
        {
            this.client.call("sim.setShapeColor", args);
        }

        public void setShapeInertia(Object... args) throws CborException
        {
            this.client.call("sim.setShapeInertia", args);
        }

        public void setShapeMass(Object... args) throws CborException
        {
            this.client.call("sim.setShapeMass", args);
        }

        public void setShapeMaterial(Object... args) throws CborException
        {
            this.client.call("sim.setShapeMaterial", args);
        }

        public void setShapeTexture(Object... args) throws CborException
        {
            this.client.call("sim.setShapeTexture", args);
        }

        public Long setStepping(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.setStepping", args);
            return ((Long)rets[0]);
        }

        public void setStringParam(Object... args) throws CborException
        {
            this.client.call("sim.setStringParam", args);
        }

        public void setStringSignal(Object... args) throws CborException
        {
            this.client.call("sim.setStringSignal", args);
        }

        public void setVisionSensorImg(Object... args) throws CborException
        {
            this.client.call("sim.setVisionSensorImg", args);
        }

        public void startSimulation(Object... args) throws CborException
        {
            this.client.call("sim.startSimulation", args);
        }

        public void step(Object... args) throws CborException
        {
            this.client.call("sim.step", args);
        }

        public void stopSimulation(Object... args) throws CborException
        {
            this.client.call("sim.stopSimulation", args);
        }

        public Long subtractObjectFromOctree(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.subtractObjectFromOctree", args);
            return ((Long)rets[0]);
        }

        public Long subtractObjectFromPointCloud(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.subtractObjectFromPointCloud", args);
            return ((Long)rets[0]);
        }

        public Long testCB(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.testCB", args);
            return ((Long)rets[0]);
        }

        public Object[] textEditorClose(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.textEditorClose", args);
            return rets;
        }

        public Object[] textEditorGetInfo(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.textEditorGetInfo", args);
            return rets;
        }

        public Long textEditorOpen(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.textEditorOpen", args);
            return ((Long)rets[0]);
        }

        public void textEditorShow(Object... args) throws CborException
        {
            this.client.call("sim.textEditorShow", args);
        }

        public byte[] transformBuffer(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.transformBuffer", args);
            return ((byte[])rets[0]);
        }

        public void transformImage(Object... args) throws CborException
        {
            this.client.call("sim.transformImage", args);
        }

        public List<Long> ungroupShape(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.ungroupShape", args);
            return ((List<Long>)rets[0]);
        }

        public List<Double> unpackDoubleTable(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.unpackDoubleTable", args);
            return ((List<Double>)rets[0]);
        }

        public List<Double> unpackFloatTable(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.unpackFloatTable", args);
            return ((List<Double>)rets[0]);
        }

        public List<Long> unpackInt32Table(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.unpackInt32Table", args);
            return ((List<Long>)rets[0]);
        }

        public Object unpackTable(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.unpackTable", args);
            return ((Object)rets[0]);
        }

        public List<Long> unpackUInt16Table(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.unpackUInt16Table", args);
            return ((List<Long>)rets[0]);
        }

        public List<Long> unpackUInt32Table(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.unpackUInt32Table", args);
            return ((List<Long>)rets[0]);
        }

        public List<Long> unpackUInt8Table(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.unpackUInt8Table", args);
            return ((List<Long>)rets[0]);
        }

        public void visitTree(Object... args) throws CborException
        {
            this.client.call("sim.visitTree", args);
        }

        public Double wait(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.wait", args);
            return ((Double)rets[0]);
        }

        public Object waitForSignal(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.waitForSignal", args);
            return ((Object)rets[0]);
        }

        public void writeCustomDataBlock(Object... args) throws CborException
        {
            this.client.call("sim.writeCustomDataBlock", args);
        }

        public void writeCustomDataBlockEx(Object... args) throws CborException
        {
            this.client.call("sim.writeCustomDataBlockEx", args);
        }

        public void writeCustomTableData(Object... args) throws CborException
        {
            this.client.call("sim.writeCustomTableData", args);
        }

        public void writeTexture(Object... args) throws CborException
        {
            this.client.call("sim.writeTexture", args);
        }

        public Object[] yawPitchRollToAlphaBetaGamma(Object... args) throws CborException
        {
            Object[] rets = this.client.call("sim.yawPitchRollToAlphaBetaGamma", args);
            return rets;
        }

        public void yield(Object... args) throws CborException
        {
            this.client.call("sim.yield", args);
        }

        public static final int addonscriptcall_cleanup = 1;
        public static final int addonscriptcall_initialization = 2;
        public static final int addonscriptcall_restarting = 17;
        public static final int addonscriptcall_run = 15;
        public static final int addonscriptcall_suspend = 16;
        public static final int api_error_output = 2;
        public static final int api_error_report = 1;
        public static final int api_warning_output = 4;
        public static final int appobj_2delement_type = 116;
        public static final int appobj_collection_type = 115;
        public static final int appobj_collision_type = 110;
        public static final int appobj_distance_type = 111;
        public static final int appobj_ik_type = 113;
        public static final int appobj_object_type = 109;
        public static final int appobj_pathplanning_type = 118;
        public static final int appobj_script_type = 117;
        public static final int appobj_simulation_type = 112;
        public static final int appobj_texture_type = 120;
        public static final int appobj_ui_type = 116;
        public static final int arrayparam_ambient_light = 5;
        public static final int arrayparam_background_color1 = 3;
        public static final int arrayparam_background_color2 = 4;
        public static final int arrayparam_fog = 1;
        public static final int arrayparam_fog_color = 2;
        public static final int arrayparam_gravity = 0;
        public static final int arrayparam_random_euler = 6;
        public static final int arrayparam_raydirection = 8;
        public static final int arrayparam_rayorigin = 7;
        public static final int banner_backfaceculling = 512;
        public static final int banner_bitmapfont = 2048;
        public static final int banner_clickselectsparent = 32;
        public static final int banner_clicktriggersevent = 64;
        public static final int banner_facingcamera = 128;
        public static final int banner_followparentvisibility = 16;
        public static final int banner_fullyfacingcamera = 256;
        public static final int banner_keepsamesize = 1024;
        public static final int banner_left = 1;
        public static final int banner_nobackground = 4;
        public static final int banner_overlay = 8;
        public static final int banner_right = 2;
        public static final int boolparam_aux_clip_planes_enabled = 23;
        public static final int boolparam_browser_toolbarbutton_enabled = 36;
        public static final int boolparam_browser_visible = 12;
        public static final int boolparam_calcmodules_toolbarbutton_enabled = 47;
        public static final int boolparam_cansave = 60;
        public static final int boolparam_collision_handling_enabled = 2;
        public static final int boolparam_console_visible = 1;
        public static final int boolparam_display_enabled = 16;
        public static final int boolparam_distance_handling_enabled = 3;
        public static final int boolparam_dynamics_handling_enabled = 6;
        public static final int boolparam_execunsafe = 58;
        public static final int boolparam_execunsafeext = 59;
        public static final int boolparam_exit_request = 41;
        public static final int boolparam_fog_enabled = 19;
        public static final int boolparam_force_calcstruct_all = 40;
        public static final int boolparam_force_calcstruct_all_visible = 39;
        public static final int boolparam_force_show_wireless_emission = 27;
        public static final int boolparam_force_show_wireless_reception = 28;
        public static final int boolparam_full_model_copy_from_api = 24;
        public static final int boolparam_fullscreen = 33;
        public static final int boolparam_gcs_handling_enabled = 5;
        public static final int boolparam_headless = 34;
        public static final int boolparam_hierarchy_toolbarbutton_enabled = 35;
        public static final int boolparam_hierarchy_visible = 0;
        public static final int boolparam_ik_handling_enabled = 4;
        public static final int boolparam_infotext_visible = 17;
        public static final int boolparam_mill_handling_enabled = 11;
        public static final int boolparam_mirrors_enabled = 22;
        public static final int boolparam_objectrotate_toolbarbutton_enabled = 38;
        public static final int boolparam_objectshift_toolbarbutton_enabled = 37;
        public static final int boolparam_objproperties_toolbarbutton_enabled = 46;
        public static final int boolparam_pause_toolbarbutton_enabled = 43;
        public static final int boolparam_play_toolbarbutton_enabled = 42;
        public static final int boolparam_proximity_sensor_handling_enabled = 9;
        public static final int boolparam_rayvalid = 56;
        public static final int boolparam_realtime_simulation = 25;
        public static final int boolparam_rendering_sensor_handling_enabled = 10;
        public static final int boolparam_rml2_available = 20;
        public static final int boolparam_rml4_available = 21;
        public static final int boolparam_rosinterface_donotrunmainscript = 48;
        public static final int boolparam_scene_and_model_load_messages = 13;
        public static final int boolparam_scene_closing = 52;
        public static final int boolparam_shape_textures_are_visible = 15;
        public static final int boolparam_show_w_emitters = 53;
        public static final int boolparam_show_w_receivers = 54;
        public static final int boolparam_statustext_open = 18;
        public static final int boolparam_stop_toolbarbutton_enabled = 44;
        public static final int boolparam_use_glfinish_cmd = 26;
        public static final int boolparam_video_recording_triggered = 29;
        public static final int boolparam_vision_sensor_handling_enabled = 10;
        public static final int boolparam_waiting_for_trigger = 45;
        public static final int buffer_base64 = 12;
        public static final int buffer_clamp = 256;
        public static final int buffer_double = 7;
        public static final int buffer_float = 6;
        public static final int buffer_int16 = 3;
        public static final int buffer_int32 = 5;
        public static final int buffer_int8 = 1;
        public static final int buffer_split = 13;
        public static final int buffer_uint16 = 2;
        public static final int buffer_uint32 = 4;
        public static final int buffer_uint8 = 0;
        public static final int buffer_uint8argb = 11;
        public static final int buffer_uint8bgr = 9;
        public static final int buffer_uint8rgb = 8;
        public static final int buffer_uint8rgba = 10;
        public static final int bullet_body_angulardamping = 6005;
        public static final int bullet_body_autoshrinkconvex = 8004;
        public static final int bullet_body_bitcoded = 7001;
        public static final int bullet_body_friction = 6003;
        public static final int bullet_body_lineardamping = 6004;
        public static final int bullet_body_nondefaultcollisionmargingfactor = 6006;
        public static final int bullet_body_nondefaultcollisionmargingfactorconvex = 6007;
        public static final int bullet_body_oldfriction = 6002;
        public static final int bullet_body_restitution = 6001;
        public static final int bullet_body_sticky = 8001;
        public static final int bullet_body_usenondefaultcollisionmargin = 8002;
        public static final int bullet_body_usenondefaultcollisionmarginconvex = 8003;
        public static final int bullet_constraintsolvertype_dantzig = 2;
        public static final int bullet_constraintsolvertype_nncg = 1;
        public static final int bullet_constraintsolvertype_projectedgaussseidel = 3;
        public static final int bullet_constraintsolvertype_sequentialimpulse = 0;
        public static final int bullet_global_bitcoded = 1002;
        public static final int bullet_global_collisionmarginfactor = 3;
        public static final int bullet_global_computeinertias = 2002;
        public static final int bullet_global_constraintsolvertype = 1003;
        public static final int bullet_global_constraintsolvingiterations = 1001;
        public static final int bullet_global_fullinternalscaling = 2001;
        public static final int bullet_global_internalscalingfactor = 2;
        public static final int bullet_global_stepsize = 1;
        public static final int bullet_joint_normalcfm = 3003;
        public static final int bullet_joint_pospid1 = 3006;
        public static final int bullet_joint_pospid2 = 3007;
        public static final int bullet_joint_pospid3 = 3008;
        public static final int bullet_joint_stopcfm = 3002;
        public static final int bullet_joint_stoperp = 3001;
        public static final int buttonproperty_borderless = 32;
        public static final int buttonproperty_button = 0;
        public static final int buttonproperty_closeaction = 4096;
        public static final int buttonproperty_downupevent = 16384;
        public static final int buttonproperty_editbox = 3;
        public static final int buttonproperty_enabled = 16;
        public static final int buttonproperty_horizontallycentered = 64;
        public static final int buttonproperty_ignoremouse = 128;
        public static final int buttonproperty_isdown = 256;
        public static final int buttonproperty_label = 1;
        public static final int buttonproperty_nobackgroundcolor = 1024;
        public static final int buttonproperty_rollupaction = 2048;
        public static final int buttonproperty_slider = 2;
        public static final int buttonproperty_staydown = 8;
        public static final int buttonproperty_transparent = 512;
        public static final int buttonproperty_verticallycentered = 8192;
        public static final int callbackid_dynstep = 2;
        public static final int callbackid_rossubscriber = 1;
        public static final int callbackid_userdefined = 1000;
        public static final int camerafarrayparam_viewfrustum = 9013;
        public static final int camerafloatparam_far_clipping = 9009;
        public static final int camerafloatparam_near_clipping = 9008;
        public static final int camerafloatparam_ortho_size = 9002;
        public static final int camerafloatparam_perspective_angle = 9001;
        public static final int camerafloatparam_pov_aperture = 9006;
        public static final int camerafloatparam_pov_blur_distance = 9005;
        public static final int cameraintparam_disabled_light_components = 9000;
        public static final int cameraintparam_perspective_operation = 9010;
        public static final int cameraintparam_pov_blur_samples = 9007;
        public static final int cameraintparam_pov_focal_blur = 9004;
        public static final int cameraintparam_rendering_attributes = 9003;
        public static final int cameraintparam_trackedobject = 9011;
        public static final int childscriptattribute_automaticcascadingcalls = 3;
        public static final int childscriptattribute_enabled = 4;
        public static final int childscriptcall_actuation = 6;
        public static final int childscriptcall_cleanup = 1;
        public static final int childscriptcall_initialization = 2;
        public static final int childscriptcall_sensing = 7;
        public static final int colorcomponent_ambient = 0;
        public static final int colorcomponent_ambient_diffuse = 0;
        public static final int colorcomponent_auxiliary = 5;
        public static final int colorcomponent_diffuse = 1;
        public static final int colorcomponent_emission = 3;
        public static final int colorcomponent_specular = 2;
        public static final int colorcomponent_transparency = 4;
        public static final int customizationscriptattribute_activeduringsimulation = 0;
        public static final int customizationscriptattribute_cleanupbeforesave = 5;
        public static final int customizationscriptcall_aftercopy = 14;
        public static final int customizationscriptcall_beforecopy = 13;
        public static final int customizationscriptcall_cleanup = 1;
        public static final int customizationscriptcall_firstafterinstanceswitch = 12;
        public static final int customizationscriptcall_firstaftersimulation = 5;
        public static final int customizationscriptcall_initialization = 2;
        public static final int customizationscriptcall_lastbeforeinstanceswitch = 11;
        public static final int customizationscriptcall_lastbeforesimulation = 4;
        public static final int customizationscriptcall_nonsimulation = 3;
        public static final int customizationscriptcall_simulationactuation = 6;
        public static final int customizationscriptcall_simulationpause = 8;
        public static final int customizationscriptcall_simulationpausefirst = 9;
        public static final int customizationscriptcall_simulationpauselast = 10;
        public static final int customizationscriptcall_simulationsensing = 7;
        public static final int displayattribute_colorcoded = 8192;
        public static final int displayattribute_colorcodedpickpass = 4096;
        public static final int displayattribute_colorcodedtriangles = 134217728;
        public static final int displayattribute_depthpass = 2;
        public static final int displayattribute_dynamiccontentonly = 131072;
        public static final int displayattribute_forbidedges = 256;
        public static final int displayattribute_forbidwireframe = 128;
        public static final int displayattribute_forcewireframe = 64;
        public static final int displayattribute_forvisionsensor = 2048;
        public static final int displayattribute_ignorelayer = 1024;
        public static final int displayattribute_ignorerenderableflag = 1048576;
        public static final int displayattribute_mainselection = 32;
        public static final int displayattribute_mirror = 262144;
        public static final int displayattribute_nodrawingobjects = 33554432;
        public static final int displayattribute_noghosts = 8388608;
        public static final int displayattribute_noopenglcallbacks = 2097152;
        public static final int displayattribute_noparticles = 67108864;
        public static final int displayattribute_nopointclouds = 16777216;
        public static final int displayattribute_originalcolors = 512;
        public static final int displayattribute_pickpass = 4;
        public static final int displayattribute_renderpass = 1;
        public static final int displayattribute_selected = 8;
        public static final int displayattribute_thickEdges = 65536;
        public static final int displayattribute_trianglewireframe = 16384;
        public static final int displayattribute_useauxcomponent = 524288;
        public static final int distcalcmethod_dac = 1;
        public static final int distcalcmethod_dac_if_nonzero = 6;
        public static final int distcalcmethod_dl = 0;
        public static final int distcalcmethod_dl_and_dac = 3;
        public static final int distcalcmethod_dl_if_nonzero = 5;
        public static final int distcalcmethod_max_dl_dac = 2;
        public static final int distcalcmethod_sqrt_dl2_and_dac2 = 4;
        public static final int dlgret_cancel = 2;
        public static final int dlgret_no = 4;
        public static final int dlgret_ok = 1;
        public static final int dlgret_still_open = 0;
        public static final int dlgret_yes = 3;
        public static final int dlgstyle_dont_center = 32;
        public static final int dlgstyle_input = 1;
        public static final int dlgstyle_message = 0;
        public static final int dlgstyle_ok = 2;
        public static final int dlgstyle_ok_cancel = 3;
        public static final int dlgstyle_yes_no = 4;
        public static final int drawing_12percenttransparency = 32768;
        public static final int drawing_25percenttransparency = 16384;
        public static final int drawing_50percenttransparency = 8192;
        public static final int drawing_auxchannelcolor1 = 2097152;
        public static final int drawing_auxchannelcolor2 = 4194304;
        public static final int drawing_backfaceculling = 256;
        public static final int drawing_cubepoints = 6;
        public static final int drawing_cubepts = 12;
        public static final int drawing_cyclic = 4096;
        public static final int drawing_discpoints = 5;
        public static final int drawing_discpts = 11;
        public static final int drawing_emissioncolor = 65536;
        public static final int drawing_facingcamera = 131072;
        public static final int drawing_followparentvisibility = 2048;
        public static final int drawing_itemcolors = 32;
        public static final int drawing_itemsizes = 128;
        public static final int drawing_itemtransparency = 524288;
        public static final int drawing_lines = 1;
        public static final int drawing_linestrip = 8;
        public static final int drawing_local = 8388608;
        public static final int drawing_overlay = 262144;
        public static final int drawing_painttag = 1024;
        public static final int drawing_persistent = 1048576;
        public static final int drawing_points = 0;
        public static final int drawing_quadpoints = 4;
        public static final int drawing_quadpts = 10;
        public static final int drawing_spherepoints = 7;
        public static final int drawing_spherepts = 7;
        public static final int drawing_trianglepoints = 3;
        public static final int drawing_trianglepts = 9;
        public static final int drawing_triangles = 2;
        public static final int drawing_vertexcolors = 64;
        public static final int drawing_wireframe = 512;
        public static final int dummy_linktype_dynamics_force_constraint = 1;
        public static final int dummy_linktype_dynamics_loop_closure = 0;
        public static final int dummy_linktype_gcs_loop_closure = 2;
        public static final int dummy_linktype_gcs_target = 4;
        public static final int dummy_linktype_gcs_tip = 3;
        public static final int dummy_linktype_ik_tip_target = 5;
        public static final int dummyfloatparam_follow_path_offset = 10002;
        public static final int dummyfloatparam_size = 10003;
        public static final int dummyintparam_dummytype = 10000;
        public static final int dummyintparam_follow_path = 10001;
        public static final int dummyintparam_link_type = 10000;
        public static final int dummylink_dynloopclosure = 0;
        public static final int dummylink_dyntendon = 7;
        public static final int dummystringparam_assemblytag = 10004;
        public static final int dummytype_assembly = 9;
        public static final int dummytype_default = 8;
        public static final int dummytype_dynloopclosure = 0;
        public static final int dummytype_dyntendon = 7;
        public static final int dynmat_default = 2310013;
        public static final int dynmat_floor = 2310021;
        public static final int dynmat_foot = 2310018;
        public static final int dynmat_gripper = 2310020;
        public static final int dynmat_highfriction = 2310014;
        public static final int dynmat_lowfriction = 2310015;
        public static final int dynmat_nofriction = 2310016;
        public static final int dynmat_reststackgrasp = 2310017;
        public static final int dynmat_wheel = 2310019;
        public static final int filedlg_type_folder = 3;
        public static final int filedlg_type_load = 0;
        public static final int filedlg_type_load_multiple = 2;
        public static final int filedlg_type_save = 1;
        public static final int filtercomponent_3x3filter = 18;
        public static final int filtercomponent_5x5filter = 19;
        public static final int filtercomponent_addbuffer1 = 10;
        public static final int filtercomponent_addtobuffer1 = 30;
        public static final int filtercomponent_binary = 28;
        public static final int filtercomponent_blobextraction = 34;
        public static final int filtercomponent_circularcut = 23;
        public static final int filtercomponent_colorsegmentation = 33;
        public static final int filtercomponent_correlationwithbuffer1 = 32;
        public static final int filtercomponent_customized = 1000;
        public static final int filtercomponent_edge = 21;
        public static final int filtercomponent_frombuffer1 = 7;
        public static final int filtercomponent_frombuffer2 = 8;
        public static final int filtercomponent_horizontalflip = 13;
        public static final int filtercomponent_imagetocoord = 35;
        public static final int filtercomponent_intensityscale = 25;
        public static final int filtercomponent_keeporremovecolors = 26;
        public static final int filtercomponent_multiplywithbuffer1 = 12;
        public static final int filtercomponent_normalize = 24;
        public static final int filtercomponent_originaldepth = 2;
        public static final int filtercomponent_originalimage = 1;
        public static final int filtercomponent_pixelchange = 36;
        public static final int filtercomponent_rectangularcut = 22;
        public static final int filtercomponent_resize = 17;
        public static final int filtercomponent_rotate = 15;
        public static final int filtercomponent_scaleandoffsetcolors = 27;
        public static final int filtercomponent_sharpen = 20;
        public static final int filtercomponent_shift = 16;
        public static final int filtercomponent_subtractbuffer1 = 11;
        public static final int filtercomponent_subtractfrombuffer1 = 31;
        public static final int filtercomponent_swapbuffers = 9;
        public static final int filtercomponent_swapwithbuffer1 = 29;
        public static final int filtercomponent_tobuffer1 = 5;
        public static final int filtercomponent_tobuffer2 = 6;
        public static final int filtercomponent_todepthoutput = 38;
        public static final int filtercomponent_tooutput = 4;
        public static final int filtercomponent_uniformimage = 3;
        public static final int filtercomponent_velodyne = 37;
        public static final int filtercomponent_verticalflip = 14;
        public static final int floatparam_dynamic_step_size = 3;
        public static final int floatparam_maxtrisizeabs = 6;
        public static final int floatparam_mintrisizerel = 7;
        public static final int floatparam_mouse_wheel_zoom_factor = 4;
        public static final int floatparam_physicstimestep = 5;
        public static final int floatparam_rand = 0;
        public static final int floatparam_simulation_time_step = 1;
        public static final int floatparam_stereo_distance = 2;
        public static final int forcefloatparam_error_a = 5003;
        public static final int forcefloatparam_error_angle = 5007;
        public static final int forcefloatparam_error_b = 5004;
        public static final int forcefloatparam_error_g = 5005;
        public static final int forcefloatparam_error_pos = 5006;
        public static final int forcefloatparam_error_x = 5000;
        public static final int forcefloatparam_error_y = 5001;
        public static final int forcefloatparam_error_z = 5002;
        public static final int graphintparam_needs_refresh = 10500;
        public static final int handle_all = -2;
        public static final int handle_all_except_explicit = -3;
        public static final int handle_all_except_self = -10;
        public static final int handle_app = -13;
        public static final int handle_chain = -7;
        public static final int handle_default = -9;
        public static final int handle_inverse = -14;
        public static final int handle_main_script = -5;
        public static final int handle_parent = -11;
        public static final int handle_scene = -12;
        public static final int handle_self = -4;
        public static final int handle_single = -8;
        public static final int handle_tree = -6;
        public static final int handle_world = -1;
        public static final int handleflag_abscoords = 8388608;
        public static final int handleflag_addmultiple = 16777216;
        public static final int handleflag_altname = 4194304;
        public static final int handleflag_assembly = 4194304;
        public static final int handleflag_axis = 4194304;
        public static final int handleflag_camera = 4194304;
        public static final int handleflag_codedstring = 4194304;
        public static final int handleflag_depthbuffer = 8388608;
        public static final int handleflag_depthbuffermeters = 8388608;
        public static final int handleflag_extended = 4194304;
        public static final int handleflag_greyscale = 4194304;
        public static final int handleflag_keeporiginal = 4194304;
        public static final int handleflag_model = 8388608;
        public static final int handleflag_rawvalue = 16777216;
        public static final int handleflag_reljointbaseframe = 4194304;
        public static final int handleflag_resetforce = 4194304;
        public static final int handleflag_resetforcetorque = 12582912;
        public static final int handleflag_resettorque = 8388608;
        public static final int handleflag_setmultiple = 4194304;
        public static final int handleflag_silenterror = 33554432;
        public static final int handleflag_togglevisibility = 4194304;
        public static final int handleflag_wxyzquat = 16777216;
        public static final int ik_alpha_beta_constraint = 8;
        public static final int ik_damped_least_squares_method = 1;
        public static final int ik_gamma_constraint = 16;
        public static final int ik_jacobian_transpose_method = 2;
        public static final int ik_pseudo_inverse_method = 0;
        public static final int ik_undamped_pseudo_inverse_method = 3;
        public static final int ik_x_constraint = 1;
        public static final int ik_y_constraint = 2;
        public static final int ik_z_constraint = 4;
        public static final int ikresult_fail = 2;
        public static final int ikresult_not_performed = 0;
        public static final int ikresult_success = 1;
        public static final int imgcomb_horizontal = 1;
        public static final int imgcomb_vertical = 0;
        public static final int intparam_compilation_version = 4;
        public static final int intparam_core_count = 24;
        public static final int intparam_current_page = 5;
        public static final int intparam_dlgverbosity = 42;
        public static final int intparam_dynamic_engine = 8;
        public static final int intparam_dynamic_iteration_count = 37;
        public static final int intparam_dynamic_step_divider = 7;
        public static final int intparam_dynamic_warning_disabled_mask = 32;
        public static final int intparam_edit_mode_type = 14;
        public static final int intparam_error_report_mode = 0;
        public static final int intparam_exitcode = 44;
        public static final int intparam_flymode_camera_handle = 6;
        public static final int intparam_hierarchychangecounter = 50;
        public static final int intparam_idle_fps = 26;
        public static final int intparam_infotext_style = 12;
        public static final int intparam_motionplanning_seed = 35;
        public static final int intparam_mouse_buttons = 31;
        public static final int intparam_mouse_x = 22;
        public static final int intparam_mouse_y = 23;
        public static final int intparam_mouseclickcounterdown = 46;
        public static final int intparam_mouseclickcounterup = 47;
        public static final int intparam_objectcreationcounter = 48;
        public static final int intparam_objectdestructioncounter = 49;
        public static final int intparam_platform = 19;
        public static final int intparam_program_full_version = 39;
        public static final int intparam_program_revision = 30;
        public static final int intparam_program_version = 1;
        public static final int intparam_prox_sensor_select_down = 27;
        public static final int intparam_prox_sensor_select_up = 28;
        public static final int intparam_qt_version = 16;
        public static final int intparam_scene_index = 34;
        public static final int intparam_scene_unique_id = 20;
        public static final int intparam_server_port_next = 15;
        public static final int intparam_server_port_range = 10;
        public static final int intparam_server_port_start = 9;
        public static final int intparam_settings = 13;
        public static final int intparam_simulation_warning_disabled_mask = 33;
        public static final int intparam_speedmodifier = 36;
        public static final int intparam_statusbarverbosity = 41;
        public static final int intparam_stop_request_counter = 29;
        public static final int intparam_verbosity = 40;
        public static final int intparam_videoencoderindex = 43;
        public static final int intparam_visible_layers = 11;
        public static final int intparam_work_thread_calc_time_ms = 25;
        public static final int intparam_work_thread_count = 21;
        public static final int joint_prismatic_subtype = 11;
        public static final int joint_revolute_subtype = 10;
        public static final int joint_spherical_subtype = 12;
        public static final int jointdynctrl_callback = 16;
        public static final int jointdynctrl_force = 1;
        public static final int jointdynctrl_free = 0;
        public static final int jointdynctrl_position = 8;
        public static final int jointdynctrl_spring = 12;
        public static final int jointdynctrl_velocity = 4;
        public static final int jointfloatparam_error_a = 2025;
        public static final int jointfloatparam_error_angle = 2029;
        public static final int jointfloatparam_error_b = 2026;
        public static final int jointfloatparam_error_g = 2027;
        public static final int jointfloatparam_error_pos = 2028;
        public static final int jointfloatparam_error_x = 2022;
        public static final int jointfloatparam_error_y = 2023;
        public static final int jointfloatparam_error_z = 2024;
        public static final int jointfloatparam_ik_weight = 2021;
        public static final int jointfloatparam_intrinsic_qw = 2011;
        public static final int jointfloatparam_intrinsic_qx = 2008;
        public static final int jointfloatparam_intrinsic_qy = 2009;
        public static final int jointfloatparam_intrinsic_qz = 2010;
        public static final int jointfloatparam_intrinsic_x = 2005;
        public static final int jointfloatparam_intrinsic_y = 2006;
        public static final int jointfloatparam_intrinsic_z = 2007;
        public static final int jointfloatparam_kc_c = 2019;
        public static final int jointfloatparam_kc_k = 2018;
        public static final int jointfloatparam_maxaccel = 2037;
        public static final int jointfloatparam_maxjerk = 2038;
        public static final int jointfloatparam_maxvel = 2036;
        public static final int jointfloatparam_pid_d = 2004;
        public static final int jointfloatparam_pid_i = 2003;
        public static final int jointfloatparam_pid_p = 2002;
        public static final int jointfloatparam_screw_pitch = 2034;
        public static final int jointfloatparam_screwlead = 2042;
        public static final int jointfloatparam_spherical_qw = 2016;
        public static final int jointfloatparam_spherical_qx = 2013;
        public static final int jointfloatparam_spherical_qy = 2014;
        public static final int jointfloatparam_spherical_qz = 2015;
        public static final int jointfloatparam_step_size = 2035;
        public static final int jointfloatparam_upper_limit = 2017;
        public static final int jointfloatparam_velocity = 2012;
        public static final int jointfloatparam_vortex_dep_multiplication = 2032;
        public static final int jointfloatparam_vortex_dep_offset = 2033;
        public static final int jointintparam_ctrl_enabled = 2001;
        public static final int jointintparam_dynctrlmode = 2039;
        public static final int jointintparam_dynposctrltype = 2041;
        public static final int jointintparam_dynvelctrltype = 2040;
        public static final int jointintparam_motor_enabled = 2000;
        public static final int jointintparam_velocity_lock = 2030;
        public static final int jointintparam_vortex_dep_handle = 2031;
        public static final int jointmode_dependent = 4;
        public static final int jointmode_dynamic = 5;
        public static final int jointmode_force = 5;
        public static final int jointmode_ik = 2;
        public static final int jointmode_ikdependent = 3;
        public static final int jointmode_kinematic = 0;
        public static final int jointmode_passive = 0;
        public static final int light_directional_subtype = 3;
        public static final int light_omnidirectional_subtype = 1;
        public static final int light_spot_subtype = 2;
        public static final int lightfloatparam_const_attenuation = 8003;
        public static final int lightfloatparam_lin_attenuation = 8004;
        public static final int lightfloatparam_quad_attenuation = 8005;
        public static final int lightfloatparam_spot_cutoff = 8002;
        public static final int lightfloatparam_spot_exponent = 8001;
        public static final int lightintparam_pov_casts_shadows = 8000;
        public static final int mainscriptcall_cleanup = 1;
        public static final int mainscriptcall_initialization = 2;
        public static final int mainscriptcall_regular = 6;
        public static final int message_bannerclicked = 7;
        public static final int message_keypress = 6;
        public static final int message_model_loaded = 4;
        public static final int message_object_selection_changed = 2;
        public static final int message_pick_select_down = 11;
        public static final int message_prox_sensor_select_down = 9;
        public static final int message_prox_sensor_select_up = 10;
        public static final int message_scene_loaded = 8;
        public static final int message_ui_button_state_change = 0;
        public static final int mill_cone_subtype = 43;
        public static final int mill_cylinder_subtype = 41;
        public static final int mill_disc_subtype = 42;
        public static final int mill_pyramid_subtype = 40;
        public static final int millintparam_volume_type = 11000;
        public static final int mirrorfloatparam_height = 12001;
        public static final int mirrorfloatparam_reflectance = 12002;
        public static final int mirrorfloatparam_width = 12000;
        public static final int mirrorintparam_enable = 12003;
        public static final int modelproperty_not_collidable = 1;
        public static final int modelproperty_not_detectable = 8;
        public static final int modelproperty_not_dynamic = 32;
        public static final int modelproperty_not_measurable = 2;
        public static final int modelproperty_not_model = 61440;
        public static final int modelproperty_not_renderable = 4;
        public static final int modelproperty_not_reset = 128;
        public static final int modelproperty_not_respondable = 64;
        public static final int modelproperty_not_showasinsidemodel = 1024;
        public static final int modelproperty_not_visible = 256;
        public static final int modelproperty_scripts_inactive = 512;
        public static final int moduleinfo_builddatestr = 1;
        public static final int moduleinfo_extversionint = 2;
        public static final int moduleinfo_extversionstr = 0;
        public static final int moduleinfo_statusbarverbosity = 4;
        public static final int moduleinfo_verbosity = 3;
        public static final int msgbox_buttons_ok = 0;
        public static final int msgbox_buttons_okcancel = 3;
        public static final int msgbox_buttons_yesno = 1;
        public static final int msgbox_buttons_yesnocancel = 2;
        public static final int msgbox_return_cancel = 0;
        public static final int msgbox_return_error = 4;
        public static final int msgbox_return_no = 1;
        public static final int msgbox_return_ok = 3;
        public static final int msgbox_return_yes = 2;
        public static final int msgbox_type_critical = 3;
        public static final int msgbox_type_info = 0;
        public static final int msgbox_type_question = 1;
        public static final int msgbox_type_warning = 2;
        public static final int mujoco_body_condim = 44001;
        public static final int mujoco_body_friction1 = 43001;
        public static final int mujoco_body_friction2 = 43002;
        public static final int mujoco_body_friction3 = 43003;
        public static final int mujoco_body_margin = 43012;
        public static final int mujoco_body_priority = 44002;
        public static final int mujoco_body_solimp1 = 43006;
        public static final int mujoco_body_solimp2 = 43007;
        public static final int mujoco_body_solimp3 = 43008;
        public static final int mujoco_body_solimp4 = 43009;
        public static final int mujoco_body_solimp5 = 43010;
        public static final int mujoco_body_solmix = 43011;
        public static final int mujoco_body_solref1 = 43004;
        public static final int mujoco_body_solref2 = 43005;
        public static final int mujoco_dummy_bitcoded = 47001;
        public static final int mujoco_dummy_damping = 46013;
        public static final int mujoco_dummy_limited = 48001;
        public static final int mujoco_dummy_margin = 46010;
        public static final int mujoco_dummy_proxyjointid = 47002;
        public static final int mujoco_dummy_range1 = 46001;
        public static final int mujoco_dummy_range2 = 46002;
        public static final int mujoco_dummy_solimplimit1 = 46005;
        public static final int mujoco_dummy_solimplimit2 = 46006;
        public static final int mujoco_dummy_solimplimit3 = 46007;
        public static final int mujoco_dummy_solimplimit4 = 46008;
        public static final int mujoco_dummy_solimplimit5 = 46009;
        public static final int mujoco_dummy_solreflimit1 = 46003;
        public static final int mujoco_dummy_solreflimit2 = 46004;
        public static final int mujoco_dummy_springlength = 46011;
        public static final int mujoco_dummy_stiffness = 46012;
        public static final int mujoco_global_balanceinertias = 39004;
        public static final int mujoco_global_bitcoded = 38001;
        public static final int mujoco_global_boundinertia = 37009;
        public static final int mujoco_global_boundmass = 37008;
        public static final int mujoco_global_computeinertias = 39001;
        public static final int mujoco_global_cone = 38007;
        public static final int mujoco_global_density = 37006;
        public static final int mujoco_global_impratio = 37002;
        public static final int mujoco_global_integrator = 38003;
        public static final int mujoco_global_iterations = 38002;
        public static final int mujoco_global_kininertia = 37019;
        public static final int mujoco_global_kinmass = 37018;
        public static final int mujoco_global_multiccd = 39003;
        public static final int mujoco_global_multithreaded = 39002;
        public static final int mujoco_global_nconmax = 38006;
        public static final int mujoco_global_njmax = 38005;
        public static final int mujoco_global_nstack = 38009;
        public static final int mujoco_global_overridecontacts = 39005;
        public static final int mujoco_global_overridekin = 38008;
        public static final int mujoco_global_overridemargin = 37010;
        public static final int mujoco_global_overridesolimp1 = 37013;
        public static final int mujoco_global_overridesolimp2 = 37014;
        public static final int mujoco_global_overridesolimp3 = 37015;
        public static final int mujoco_global_overridesolimp4 = 37016;
        public static final int mujoco_global_overridesolimp5 = 37017;
        public static final int mujoco_global_overridesolref1 = 37011;
        public static final int mujoco_global_overridesolref2 = 37012;
        public static final int mujoco_global_rebuildtrigger = 38010;
        public static final int mujoco_global_solver = 38004;
        public static final int mujoco_global_viscosity = 37007;
        public static final int mujoco_global_wind1 = 37003;
        public static final int mujoco_global_wind2 = 37004;
        public static final int mujoco_global_wind3 = 37005;
        public static final int mujoco_joint_armature = 40021;
        public static final int mujoco_joint_damping = 40017;
        public static final int mujoco_joint_dependentobjectid = 41002;
        public static final int mujoco_joint_frictionloss = 40008;
        public static final int mujoco_joint_margin = 40022;
        public static final int mujoco_joint_polycoef1 = 40023;
        public static final int mujoco_joint_polycoef2 = 40024;
        public static final int mujoco_joint_polycoef3 = 40025;
        public static final int mujoco_joint_polycoef4 = 40026;
        public static final int mujoco_joint_polycoef5 = 40027;
        public static final int mujoco_joint_pospid1 = 40028;
        public static final int mujoco_joint_pospid2 = 40029;
        public static final int mujoco_joint_pospid3 = 40030;
        public static final int mujoco_joint_solimpfriction1 = 40011;
        public static final int mujoco_joint_solimpfriction2 = 40012;
        public static final int mujoco_joint_solimpfriction3 = 40013;
        public static final int mujoco_joint_solimpfriction4 = 40014;
        public static final int mujoco_joint_solimpfriction5 = 40015;
        public static final int mujoco_joint_solimplimit1 = 40003;
        public static final int mujoco_joint_solimplimit2 = 40004;
        public static final int mujoco_joint_solimplimit3 = 40005;
        public static final int mujoco_joint_solimplimit4 = 40006;
        public static final int mujoco_joint_solimplimit5 = 40007;
        public static final int mujoco_joint_solreffriction1 = 40009;
        public static final int mujoco_joint_solreffriction2 = 40010;
        public static final int mujoco_joint_solreflimit1 = 40001;
        public static final int mujoco_joint_solreflimit2 = 40002;
        public static final int mujoco_joint_springdamper1 = 40019;
        public static final int mujoco_joint_springdamper2 = 40020;
        public static final int mujoco_joint_springref = 40018;
        public static final int mujoco_joint_stiffness = 40016;
        public static final int navigation_cameraangle = 5;
        public static final int navigation_camerafly = 6;
        public static final int navigation_camerarotate = 2;
        public static final int navigation_camerarotatemiddlebutton = 8192;
        public static final int navigation_camerarotaterightbutton = 8192;
        public static final int navigation_camerashift = 1;
        public static final int navigation_cameratilt = 4;
        public static final int navigation_camerazoom = 3;
        public static final int navigation_camerazoomwheel = 4096;
        public static final int navigation_clickselection = 512;
        public static final int navigation_createpathpoint = 256;
        public static final int navigation_ctrlselection = 1024;
        public static final int navigation_objectrotate = 8;
        public static final int navigation_objectshift = 7;
        public static final int navigation_passive = 0;
        public static final int navigation_shiftselection = 2048;
        public static final int newton_body_angulardrag = 33005;
        public static final int newton_body_bitcoded = 34001;
        public static final int newton_body_fastmoving = 35001;
        public static final int newton_body_kineticfriction = 33002;
        public static final int newton_body_lineardrag = 33004;
        public static final int newton_body_restitution = 33003;
        public static final int newton_body_staticfriction = 33001;
        public static final int newton_global_bitcoded = 28002;
        public static final int newton_global_computeinertias = 29004;
        public static final int newton_global_constraintsolvingiterations = 28001;
        public static final int newton_global_contactmergetolerance = 27002;
        public static final int newton_global_exactsolver = 29002;
        public static final int newton_global_highjointaccuracy = 29003;
        public static final int newton_global_multithreading = 29001;
        public static final int newton_global_stepsize = 27001;
        public static final int newton_joint_dependencyfactor = 30001;
        public static final int newton_joint_dependencyoffset = 30002;
        public static final int newton_joint_dependentobjectid = 31002;
        public static final int newton_joint_objectid = 31001;
        public static final int newton_joint_pospid1 = 30003;
        public static final int newton_joint_pospid2 = 30004;
        public static final int newton_joint_pospid3 = 30005;
        public static final int object_camera_type = 3;
        public static final int object_dummy_type = 4;
        public static final int object_forcesensor_type = 12;
        public static final int object_graph_type = 2;
        public static final int object_joint_type = 1;
        public static final int object_light_type = 13;
        public static final int object_mill_type = 11;
        public static final int object_mirror_type = 14;
        public static final int object_no_subtype = 200;
        public static final int object_octree_type = 15;
        public static final int object_path_type = 8;
        public static final int object_pointcloud_type = 16;
        public static final int object_proximitysensor_type = 5;
        public static final int object_renderingsensor_type = 9;
        public static final int object_shape_type = 0;
        public static final int object_visionsensor_type = 9;
        public static final int objectproperty_cannotdelete = 8192;
        public static final int objectproperty_cannotdeleteduringsim = 16384;
        public static final int objectproperty_canupdatedna = 1024;
        public static final int objectproperty_collapsed = 16;
        public static final int objectproperty_depthinvisible = 4096;
        public static final int objectproperty_dontshowasinsidemodel = 256;
        public static final int objectproperty_hiddenforsimulation = 65536;
        public static final int objectproperty_hierarchyhiddenmodelchild = 32768;
        public static final int objectproperty_ignoreviewfitting = 1;
        public static final int objectproperty_selectable = 32;
        public static final int objectproperty_selectinvisible = 2048;
        public static final int objectproperty_selectmodelbaseinstead = 128;
        public static final int objectspecialproperty_collidable = 1;
        public static final int objectspecialproperty_detectable = 496;
        public static final int objectspecialproperty_detectable_all = 496;
        public static final int objectspecialproperty_detectable_capacitive = 256;
        public static final int objectspecialproperty_detectable_inductive = 128;
        public static final int objectspecialproperty_detectable_infrared = 32;
        public static final int objectspecialproperty_detectable_laser = 64;
        public static final int objectspecialproperty_detectable_ultrasonic = 16;
        public static final int objectspecialproperty_measurable = 2;
        public static final int objectspecialproperty_pathplanning_ignored = 2048;
        public static final int objectspecialproperty_renderable = 512;
        public static final int objfloatparam_abs_rot_velocity = 14;
        public static final int objfloatparam_abs_x_velocity = 11;
        public static final int objfloatparam_abs_y_velocity = 12;
        public static final int objfloatparam_abs_z_velocity = 13;
        public static final int objfloatparam_modelbbox_max_x = 24;
        public static final int objfloatparam_modelbbox_max_y = 25;
        public static final int objfloatparam_modelbbox_max_z = 26;
        public static final int objfloatparam_modelbbox_min_x = 21;
        public static final int objfloatparam_modelbbox_min_y = 22;
        public static final int objfloatparam_modelbbox_min_z = 23;
        public static final int objfloatparam_objbbox_max_x = 18;
        public static final int objfloatparam_objbbox_max_y = 19;
        public static final int objfloatparam_objbbox_max_z = 20;
        public static final int objfloatparam_objbbox_min_x = 15;
        public static final int objfloatparam_objbbox_min_y = 16;
        public static final int objfloatparam_objbbox_min_z = 17;
        public static final int objfloatparam_size_factor = 34;
        public static final int objfloatparam_transparency_offset = 28;
        public static final int objintparam_child_role = 29;
        public static final int objintparam_collection_self_collision_indicator = 27;
        public static final int objintparam_hierarchycolor = 38;
        public static final int objintparam_illumination_handle = 32;
        public static final int objintparam_manipulation_permissions = 31;
        public static final int objintparam_parent_role = 30;
        public static final int objintparam_unique_id = 37;
        public static final int objintparam_visibility_layer = 10;
        public static final int objintparam_visible = 36;
        public static final int objstringparam_dna = 33;
        public static final int objstringparam_unique_id = 35;
        public static final int ode_body_angulardamping = 15005;
        public static final int ode_body_friction = 15001;
        public static final int ode_body_lineardamping = 15004;
        public static final int ode_body_maxcontacts = 16001;
        public static final int ode_body_softcfm = 15003;
        public static final int ode_body_softerp = 15002;
        public static final int ode_global_bitcoded = 10002;
        public static final int ode_global_cfm = 9003;
        public static final int ode_global_computeinertias = 11003;
        public static final int ode_global_constraintsolvingiterations = 10001;
        public static final int ode_global_erp = 9004;
        public static final int ode_global_fullinternalscaling = 11001;
        public static final int ode_global_internalscalingfactor = 9002;
        public static final int ode_global_quickstep = 11002;
        public static final int ode_global_randomseed = 10003;
        public static final int ode_global_stepsize = 9001;
        public static final int ode_joint_bounce = 12003;
        public static final int ode_joint_fudgefactor = 12004;
        public static final int ode_joint_normalcfm = 12005;
        public static final int ode_joint_pospid1 = 12006;
        public static final int ode_joint_pospid2 = 12007;
        public static final int ode_joint_pospid3 = 12008;
        public static final int ode_joint_stopcfm = 12002;
        public static final int ode_joint_stoperp = 12001;
        public static final int particle_cyclic = 8192;
        public static final int particle_emissioncolor = 16384;
        public static final int particle_ignoresgravity = 256;
        public static final int particle_invisible = 512;
        public static final int particle_itemcolors = 4096;
        public static final int particle_itemdensities = 2048;
        public static final int particle_itemsizes = 1024;
        public static final int particle_painttag = 65536;
        public static final int particle_particlerespondable = 128;
        public static final int particle_points1 = 0;
        public static final int particle_points2 = 1;
        public static final int particle_points4 = 2;
        public static final int particle_respondable1to4 = 32;
        public static final int particle_respondable5to8 = 64;
        public static final int particle_roughspheres = 3;
        public static final int particle_spheres = 4;
        public static final int particle_water = 32768;
        public static final int pathproperty_automatic_orientation = 8;
        public static final int pathproperty_closed_path = 4;
        public static final int pathproperty_flat_path = 64;
        public static final int pathproperty_keep_x_up = 2048;
        public static final int pathproperty_show_line = 1;
        public static final int pathproperty_show_orientation = 2;
        public static final int pathproperty_show_position = 128;
        public static final int physics_bullet = 0;
        public static final int physics_mujoco = 4;
        public static final int physics_newton = 3;
        public static final int physics_ode = 1;
        public static final int physics_physx = 5;
        public static final int physics_vortex = 2;
        public static final int plugininfo_builddatestr = 1;
        public static final int plugininfo_extversionint = 2;
        public static final int plugininfo_extversionstr = 0;
        public static final int plugininfo_statusbarverbosity = 4;
        public static final int plugininfo_verbosity = 3;
        public static final int primitiveshape_capsule = 8;
        public static final int primitiveshape_cone = 6;
        public static final int primitiveshape_cuboid = 3;
        public static final int primitiveshape_cylinder = 5;
        public static final int primitiveshape_disc = 2;
        public static final int primitiveshape_heightfield = 7;
        public static final int primitiveshape_none = 0;
        public static final int primitiveshape_plane = 1;
        public static final int primitiveshape_spheroid = 4;
        public static final int proximitysensor_cone_subtype = 33;
        public static final int proximitysensor_cylinder_subtype = 31;
        public static final int proximitysensor_disc_subtype = 32;
        public static final int proximitysensor_pyramid_subtype = 30;
        public static final int proximitysensor_ray_subtype = 34;
        public static final int proxintparam_entity_to_detect = 4002;
        public static final int proxintparam_ray_invisibility = 4000;
        public static final int proxintparam_volume_type = 4001;
        public static final int pure_primitive_cone = 6;
        public static final int pure_primitive_cuboid = 3;
        public static final int pure_primitive_cylinder = 5;
        public static final int pure_primitive_disc = 2;
        public static final int pure_primitive_heightfield = 7;
        public static final int pure_primitive_none = 0;
        public static final int pure_primitive_plane = 1;
        public static final int pure_primitive_spheroid = 4;
        public static final int rml_disable_extremum_motion_states_calc = 0;
        public static final int rml_keep_current_vel_if_fallback_strategy = 0;
        public static final int rml_keep_target_vel = 0;
        public static final int rml_no_sync = 3;
        public static final int rml_only_phase_sync = 1;
        public static final int rml_only_time_sync = 1;
        public static final int rml_phase_sync_if_possible = 0;
        public static final int rml_recompute_trajectory = 0;
        public static final int ruckig_minaccel = 512;
        public static final int ruckig_minvel = 256;
        public static final int ruckig_nosync = 3;
        public static final int ruckig_phasesync = 0;
        public static final int ruckig_timesync = 1;
        public static final int script_call_error = 16;
        public static final int script_lua_error = 8;
        public static final int script_main_not_called = 2;
        public static final int script_main_script_nonexistent = 1;
        public static final int script_no_error = 0;
        public static final int script_reentrance_error = 4;
        public static final int scriptattribute_debuglevel = 6;
        public static final int scriptattribute_enabled = 4;
        public static final int scriptattribute_executioncount = 2;
        public static final int scriptattribute_executionorder = 1;
        public static final int scriptattribute_scripthandle = 8;
        public static final int scriptattribute_scripttype = 7;
        public static final int scriptdebug_allcalls = 3;
        public static final int scriptdebug_callsandvars = 5;
        public static final int scriptdebug_none = 0;
        public static final int scriptdebug_syscalls = 1;
        public static final int scriptdebug_vars = 4;
        public static final int scriptdebug_vars_interval = 2;
        public static final int scriptexecorder_first = 0;
        public static final int scriptexecorder_last = 2;
        public static final int scriptexecorder_normal = 1;
        public static final int scriptintparam_autorestartonerror = 7;
        public static final int scriptintparam_enabled = 4;
        public static final int scriptintparam_execcount = 1;
        public static final int scriptintparam_execorder = 0;
        public static final int scriptintparam_handle = 3;
        public static final int scriptintparam_lang = 6;
        public static final int scriptintparam_objecthandle = 5;
        public static final int scriptintparam_type = 2;
        public static final int scriptstringparam_description = 0;
        public static final int scriptstringparam_name = 1;
        public static final int scriptstringparam_nameext = 3;
        public static final int scriptstringparam_text = 2;
        public static final int scriptthreadresume_actuation_first = 1;
        public static final int scriptthreadresume_actuation_last = 2;
        public static final int scriptthreadresume_allnotyetresumed = -1;
        public static final int scriptthreadresume_custom = 5;
        public static final int scriptthreadresume_default = 0;
        public static final int scriptthreadresume_sensing_first = 3;
        public static final int scriptthreadresume_sensing_last = 4;
        public static final int scripttype_addonfunction = 3;
        public static final int scripttype_addonscript = 2;
        public static final int scripttype_childscript = 1;
        public static final int scripttype_customizationscript = 6;
        public static final int scripttype_mainscript = 0;
        public static final int scripttype_sandboxscript = 8;
        public static final int scripttype_threaded = 240;
        public static final int shape_multishape_subtype = 21;
        public static final int shape_simpleshape_subtype = 20;
        public static final int shapefloatparam_edge_angle = 3026;
        public static final int shapefloatparam_init_ang_velocity_x = 3020;
        public static final int shapefloatparam_init_ang_velocity_y = 3021;
        public static final int shapefloatparam_init_ang_velocity_z = 3022;
        public static final int shapefloatparam_init_velocity_a = 3020;
        public static final int shapefloatparam_init_velocity_b = 3021;
        public static final int shapefloatparam_init_velocity_g = 3022;
        public static final int shapefloatparam_init_velocity_x = 3000;
        public static final int shapefloatparam_init_velocity_y = 3001;
        public static final int shapefloatparam_init_velocity_z = 3002;
        public static final int shapefloatparam_mass = 3005;
        public static final int shapefloatparam_shading_angle = 3025;
        public static final int shapefloatparam_texture_a = 3009;
        public static final int shapefloatparam_texture_b = 3010;
        public static final int shapefloatparam_texture_g = 3011;
        public static final int shapefloatparam_texture_scaling_x = 3012;
        public static final int shapefloatparam_texture_scaling_y = 3013;
        public static final int shapefloatparam_texture_x = 3006;
        public static final int shapefloatparam_texture_y = 3007;
        public static final int shapefloatparam_texture_z = 3008;
        public static final int shapeintparam_component_cnt = 3028;
        public static final int shapeintparam_compound = 3016;
        public static final int shapeintparam_convex = 3017;
        public static final int shapeintparam_convex_check = 3018;
        public static final int shapeintparam_culling = 3014;
        public static final int shapeintparam_edge_borders_hidden = 3027;
        public static final int shapeintparam_edge_visibility = 3024;
        public static final int shapeintparam_kinematic = 3030;
        public static final int shapeintparam_respondable = 3004;
        public static final int shapeintparam_respondable_mask = 3019;
        public static final int shapeintparam_respondablesuspendcnt = 3031;
        public static final int shapeintparam_sleepmodestart = 3029;
        public static final int shapeintparam_static = 3003;
        public static final int shapeintparam_wireframe = 3015;
        public static final int shapestringparam_color_name = 3023;
        public static final int shapestringparam_colorname = 3032;
        public static final int sim_lang_lua = 0;
        public static final int sim_lang_python = 1;
        public static final int sim_lang_undefined = -1;
        public static final int simulation_advancing = 16;
        public static final int simulation_advancing_abouttostop = 21;
        public static final int simulation_advancing_firstafterpause = 20;
        public static final int simulation_advancing_firstafterstop = 16;
        public static final int simulation_advancing_lastbeforepause = 19;
        public static final int simulation_advancing_lastbeforestop = 22;
        public static final int simulation_advancing_running = 17;
        public static final int simulation_paused = 8;
        public static final int simulation_stopped = 0;
        public static final int stream_transf_cumulative = 3;
        public static final int stream_transf_derivative = 1;
        public static final int stream_transf_integral = 2;
        public static final int stream_transf_raw = 0;
        public static final int stringparam_additionalpythonpath = 135;
        public static final int stringparam_addondir = 143;
        public static final int stringparam_addonpath = 131;
        public static final int stringparam_app_arg1 = 2;
        public static final int stringparam_app_arg2 = 3;
        public static final int stringparam_app_arg3 = 4;
        public static final int stringparam_app_arg4 = 5;
        public static final int stringparam_app_arg5 = 6;
        public static final int stringparam_app_arg6 = 7;
        public static final int stringparam_app_arg7 = 8;
        public static final int stringparam_app_arg8 = 9;
        public static final int stringparam_app_arg9 = 10;
        public static final int stringparam_application_path = 0;
        public static final int stringparam_datadir = 129;
        public static final int stringparam_defaultpython = 134;
        public static final int stringparam_dlgverbosity = 123;
        public static final int stringparam_importexportdir = 130;
        public static final int stringparam_legacymachinetag = 142;
        public static final int stringparam_logfilter = 124;
        public static final int stringparam_luadir = 136;
        public static final int stringparam_machine_id = 119;
        public static final int stringparam_machine_id_legacy = 120;
        public static final int stringparam_modeldefaultdir = 133;
        public static final int stringparam_mujocodir = 138;
        public static final int stringparam_pythondir = 137;
        public static final int stringparam_remoteapi_temp_file_dir = 16;
        public static final int stringparam_resourcesdir = 141;
        public static final int stringparam_sandboxlang = 144;
        public static final int stringparam_scene_name = 15;
        public static final int stringparam_scene_path = 14;
        public static final int stringparam_scene_path_and_name = 13;
        public static final int stringparam_scene_unique_id = 118;
        public static final int stringparam_scenedefaultdir = 132;
        public static final int stringparam_statusbarverbosity = 122;
        public static final int stringparam_systemdir = 140;
        public static final int stringparam_tempdir = 127;
        public static final int stringparam_tempscenedir = 128;
        public static final int stringparam_uniqueid = 126;
        public static final int stringparam_usersettingsdir = 139;
        public static final int stringparam_verbosity = 121;
        public static final int stringparam_video_filename = 1;
        public static final int syscb_actuation = 6;
        public static final int syscb_aftercopy = 14;
        public static final int syscb_aftercreate = 26;
        public static final int syscb_afterdelete = 25;
        public static final int syscb_afterinstanceswitch = 12;
        public static final int syscb_aftersimulation = 5;
        public static final int syscb_aos_resume = 17;
        public static final int syscb_aos_run = 15;
        public static final int syscb_aos_suspend = 16;
        public static final int syscb_beforecopy = 13;
        public static final int syscb_beforedelete = 24;
        public static final int syscb_beforeinstanceswitch = 11;
        public static final int syscb_beforemainscript = 29;
        public static final int syscb_beforesimulation = 4;
        public static final int syscb_cleanup = 1;
        public static final int syscb_contact = 41;
        public static final int syscb_contactcallback = 19;
        public static final int syscb_customcallback1 = 20;
        public static final int syscb_customcallback2 = 21;
        public static final int syscb_customcallback3 = 22;
        public static final int syscb_customcallback4 = 23;
        public static final int syscb_data = 45;
        public static final int syscb_dyn = 40;
        public static final int syscb_dyncallback = 28;
        public static final int syscb_init = 2;
        public static final int syscb_joint = 42;
        public static final int syscb_jointcallback = 18;
        public static final int syscb_moduleentry = 33;
        public static final int syscb_nonsimulation = 3;
        public static final int syscb_regular = 6;
        public static final int syscb_resume = 10;
        public static final int syscb_selchange = 44;
        public static final int syscb_sensing = 7;
        public static final int syscb_suspend = 9;
        public static final int syscb_suspended = 8;
        public static final int syscb_thread = 43;
        public static final int syscb_trigger = 31;
        public static final int syscb_userconfig = 32;
        public static final int syscb_vision = 30;
        public static final int texturemap_cube = 3;
        public static final int texturemap_cylinder = 1;
        public static final int texturemap_plane = 0;
        public static final int texturemap_sphere = 2;
        public static final int verbosity_debug = 600;
        public static final int verbosity_default = 400;
        public static final int verbosity_errors = 200;
        public static final int verbosity_infos = 500;
        public static final int verbosity_loadinfos = 400;
        public static final int verbosity_msgs = 450;
        public static final int verbosity_none = 100;
        public static final int verbosity_onlyterminal = 65536;
        public static final int verbosity_questions = 410;
        public static final int verbosity_scripterrors = 420;
        public static final int verbosity_scriptinfos = 450;
        public static final int verbosity_scriptwarnings = 430;
        public static final int verbosity_trace = 700;
        public static final int verbosity_traceall = 900;
        public static final int verbosity_tracelua = 800;
        public static final int verbosity_undecorated = 61440;
        public static final int verbosity_useglobal = -1;
        public static final int verbosity_warnings = 300;
        public static final int visionfarrayparam_viewfrustum = 1019;
        public static final int visionfloatparam_far_clipping = 1001;
        public static final int visionfloatparam_near_clipping = 1000;
        public static final int visionfloatparam_ortho_size = 1005;
        public static final int visionfloatparam_perspective_angle = 1004;
        public static final int visionfloatparam_pov_aperture = 1015;
        public static final int visionfloatparam_pov_blur_distance = 1014;
        public static final int visionintparam_depthignored = 1020;
        public static final int visionintparam_disabled_light_components = 1006;
        public static final int visionintparam_entity_to_render = 1008;
        public static final int visionintparam_perspective_operation = 1018;
        public static final int visionintparam_pov_blur_sampled = 1016;
        public static final int visionintparam_pov_focal_blur = 1013;
        public static final int visionintparam_render_mode = 1017;
        public static final int visionintparam_rendering_attributes = 1007;
        public static final int visionintparam_resolution_x = 1002;
        public static final int visionintparam_resolution_y = 1003;
        public static final int visionintparam_rgbignored = 1020;
        public static final int visionintparam_windowed_pos_x = 1011;
        public static final int visionintparam_windowed_pos_y = 1012;
        public static final int visionintparam_windowed_size_x = 1009;
        public static final int visionintparam_windowed_size_y = 1010;
        public static final int volume_cone = 3;
        public static final int volume_cylinder = 1;
        public static final int volume_disc = 2;
        public static final int volume_pyramid = 0;
        public static final int volume_randomizedray = 5;
        public static final int volume_ray = 4;
        public static final int vortex_body_adhesiveforce = 24015;
        public static final int vortex_body_angularvelocitydamping = 24017;
        public static final int vortex_body_autoangulardamping = 26009;
        public static final int vortex_body_autoangulardampingtensionratio = 24033;
        public static final int vortex_body_autosleepangularaccelthreshold = 24031;
        public static final int vortex_body_autosleepangularspeedthreshold = 24030;
        public static final int vortex_body_autosleeplinearaccelthreshold = 24029;
        public static final int vortex_body_autosleeplinearspeedthreshold = 24028;
        public static final int vortex_body_autosleepsteplivethreshold = 25007;
        public static final int vortex_body_autoslip = 26005;
        public static final int vortex_body_bitcoded = 25006;
        public static final int vortex_body_compliance = 24011;
        public static final int vortex_body_convexshapesasrandom = 26002;
        public static final int vortex_body_damping = 24012;
        public static final int vortex_body_fastmoving = 26004;
        public static final int vortex_body_linearvelocitydamping = 24016;
        public static final int vortex_body_materialuniqueid = 25008;
        public static final int vortex_body_normalangularaxisfriction = 24005;
        public static final int vortex_body_normalangularaxisfrictionmodel = 25005;
        public static final int vortex_body_normalangularaxisslide = 24022;
        public static final int vortex_body_normalangularaxisslip = 24027;
        public static final int vortex_body_normalangularaxisstaticfrictionscale = 24010;
        public static final int vortex_body_normalmangulararaxisfrictionmodel = 25005;
        public static final int vortex_body_normangaxissameasprimangaxis = 26008;
        public static final int vortex_body_primangulararaxisfrictionmodel = 25003;
        public static final int vortex_body_primangularaxisfriction = 24003;
        public static final int vortex_body_primangularaxisslide = 24020;
        public static final int vortex_body_primangularaxisslip = 24025;
        public static final int vortex_body_primangularaxisstaticfrictionscale = 24008;
        public static final int vortex_body_primaxisvectorx = 24034;
        public static final int vortex_body_primaxisvectory = 24035;
        public static final int vortex_body_primaxisvectorz = 24036;
        public static final int vortex_body_primlinearaxisfriction = 24001;
        public static final int vortex_body_primlinearaxisfrictionmodel = 25001;
        public static final int vortex_body_primlinearaxisslide = 24018;
        public static final int vortex_body_primlinearaxisslip = 24023;
        public static final int vortex_body_primlinearaxisstaticfrictionscale = 24006;
        public static final int vortex_body_pureshapesasconvex = 26001;
        public static final int vortex_body_randomshapesasterrain = 26003;
        public static final int vortex_body_restitution = 24013;
        public static final int vortex_body_restitutionthreshold = 24014;
        public static final int vortex_body_secangaxissameasprimangaxis = 26007;
        public static final int vortex_body_secangularaxisfriction = 24004;
        public static final int vortex_body_secangularaxisfrictionmodel = 25004;
        public static final int vortex_body_secangularaxisslide = 24021;
        public static final int vortex_body_secangularaxisslip = 24026;
        public static final int vortex_body_secangularaxisstaticfrictionscale = 24009;
        public static final int vortex_body_seclinaxissameasprimlinaxis = 26006;
        public static final int vortex_body_seclinearaxisfriction = 24002;
        public static final int vortex_body_seclinearaxisfrictionmodel = 25002;
        public static final int vortex_body_seclinearaxisslide = 24019;
        public static final int vortex_body_seclinearaxisslip = 24024;
        public static final int vortex_body_seclinearaxisstaticfrictionscale = 24007;
        public static final int vortex_body_secmangulararaxisfrictionmodel = 25004;
        public static final int vortex_body_skinthickness = 24032;
        public static final int vortex_bodyfrictionmodel_box = 0;
        public static final int vortex_bodyfrictionmodel_neutral = 5;
        public static final int vortex_bodyfrictionmodel_none = 6;
        public static final int vortex_bodyfrictionmodel_prophigh = 3;
        public static final int vortex_bodyfrictionmodel_proplow = 2;
        public static final int vortex_bodyfrictionmodel_scaledbox = 1;
        public static final int vortex_bodyfrictionmodel_scaledboxfast = 4;
        public static final int vortex_global_autosleep = 20001;
        public static final int vortex_global_bitcoded = 19001;
        public static final int vortex_global_computeinertias = 20005;
        public static final int vortex_global_constraintangularcompliance = 18007;
        public static final int vortex_global_constraintangulardamping = 18008;
        public static final int vortex_global_constraintangularkineticloss = 18009;
        public static final int vortex_global_constraintlinearcompliance = 18004;
        public static final int vortex_global_constraintlineardamping = 18005;
        public static final int vortex_global_constraintlinearkineticloss = 18006;
        public static final int vortex_global_contacttolerance = 18003;
        public static final int vortex_global_internalscalingfactor = 18002;
        public static final int vortex_global_multithreading = 20002;
        public static final int vortex_global_stepsize = 18001;
        public static final int vortex_joint_a0damping = 21032;
        public static final int vortex_joint_a0frictioncoeff = 21033;
        public static final int vortex_joint_a0frictionloss = 21035;
        public static final int vortex_joint_a0frictionmaxforce = 21034;
        public static final int vortex_joint_a0loss = 21030;
        public static final int vortex_joint_a0stiffness = 21031;
        public static final int vortex_joint_a1damping = 21038;
        public static final int vortex_joint_a1frictioncoeff = 21039;
        public static final int vortex_joint_a1frictionloss = 21041;
        public static final int vortex_joint_a1frictionmaxforce = 21040;
        public static final int vortex_joint_a1loss = 21036;
        public static final int vortex_joint_a1stiffness = 21037;
        public static final int vortex_joint_a2damping = 21044;
        public static final int vortex_joint_a2frictioncoeff = 21045;
        public static final int vortex_joint_a2frictionloss = 21047;
        public static final int vortex_joint_a2frictionmaxforce = 21046;
        public static final int vortex_joint_a2loss = 21042;
        public static final int vortex_joint_a2stiffness = 21043;
        public static final int vortex_joint_bitcoded = 22001;
        public static final int vortex_joint_dependencyfactor = 21048;
        public static final int vortex_joint_dependencyoffset = 21049;
        public static final int vortex_joint_dependentobjectid = 22006;
        public static final int vortex_joint_frictionenabledbc = 22003;
        public static final int vortex_joint_frictionproportionalbc = 22004;
        public static final int vortex_joint_lowerlimitdamping = 21001;
        public static final int vortex_joint_lowerlimitmaxforce = 21007;
        public static final int vortex_joint_lowerlimitrestitution = 21005;
        public static final int vortex_joint_lowerlimitstiffness = 21003;
        public static final int vortex_joint_motorconstraintfrictioncoeff = 21009;
        public static final int vortex_joint_motorconstraintfrictionloss = 21011;
        public static final int vortex_joint_motorconstraintfrictionmaxforce = 21010;
        public static final int vortex_joint_motorfrictionenabled = 23001;
        public static final int vortex_joint_objectid = 22005;
        public static final int vortex_joint_p0damping = 21014;
        public static final int vortex_joint_p0frictioncoeff = 21015;
        public static final int vortex_joint_p0frictionloss = 21017;
        public static final int vortex_joint_p0frictionmaxforce = 21016;
        public static final int vortex_joint_p0loss = 21012;
        public static final int vortex_joint_p0stiffness = 21013;
        public static final int vortex_joint_p1damping = 21020;
        public static final int vortex_joint_p1frictioncoeff = 21021;
        public static final int vortex_joint_p1frictionloss = 21023;
        public static final int vortex_joint_p1frictionmaxforce = 21022;
        public static final int vortex_joint_p1loss = 21018;
        public static final int vortex_joint_p1stiffness = 21019;
        public static final int vortex_joint_p2damping = 21026;
        public static final int vortex_joint_p2frictioncoeff = 21027;
        public static final int vortex_joint_p2frictionloss = 21029;
        public static final int vortex_joint_p2frictionmaxforce = 21028;
        public static final int vortex_joint_p2loss = 21024;
        public static final int vortex_joint_p2stiffness = 21025;
        public static final int vortex_joint_pospid1 = 21052;
        public static final int vortex_joint_pospid2 = 21053;
        public static final int vortex_joint_pospid3 = 21054;
        public static final int vortex_joint_proportionalmotorfriction = 23002;
        public static final int vortex_joint_relaxationenabledbc = 22002;
        public static final int vortex_joint_upperlimitdamping = 21002;
        public static final int vortex_joint_upperlimitmaxforce = 21008;
        public static final int vortex_joint_upperlimitrestitution = 21006;
        public static final int vortex_joint_upperlimitstiffness = 21004;
    }

    public _sim sim() {
        return new _sim(this.client);
    }

    public class _simIK extends RemoteAPIObject
    {
        public _simIK(RemoteAPIClient client)
        {
            super(client);
        }

        public Long addElement(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.addElement", args);
            return ((Long)rets[0]);
        }

        public Object[] addElementFromScene(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.addElementFromScene", args);
            return rets;
        }

        public Object[] computeGroupJacobian(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.computeGroupJacobian", args);
            return rets;
        }

        public Object[] computeJacobian(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.computeJacobian", args);
            return rets;
        }

        public Long createDebugOverlay(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.createDebugOverlay", args);
            return ((Long)rets[0]);
        }

        public Long createDummy(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.createDummy", args);
            return ((Long)rets[0]);
        }

        public Long createEnvironment(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.createEnvironment", args);
            return ((Long)rets[0]);
        }

        public Long createGroup(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.createGroup", args);
            return ((Long)rets[0]);
        }

        public Long createJoint(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.createJoint", args);
            return ((Long)rets[0]);
        }

        public Boolean doesGroupExist(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.doesGroupExist", args);
            return ((Boolean)rets[0]);
        }

        public Boolean doesObjectExist(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.doesObjectExist", args);
            return ((Boolean)rets[0]);
        }

        public Long duplicateEnvironment(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.duplicateEnvironment", args);
            return ((Long)rets[0]);
        }

        public void eraseDebugOverlay(Object... args) throws CborException
        {
            this.client.call("simIK.eraseDebugOverlay", args);
        }

        public void eraseEnvironment(Object... args) throws CborException
        {
            this.client.call("simIK.eraseEnvironment", args);
        }

        public void eraseObject(Object... args) throws CborException
        {
            this.client.call("simIK.eraseObject", args);
        }

        public List<Double> findConfig(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.findConfig", args);
            return ((List<Double>)rets[0]);
        }

        public List<Double> generatePath(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.generatePath", args);
            return ((List<Double>)rets[0]);
        }

        public List<Double> getAlternateConfigs(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.getAlternateConfigs", args);
            return ((List<Double>)rets[0]);
        }

        public Object[] getElementBase(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.getElementBase", args);
            return rets;
        }

        public Long getElementConstraints(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.getElementConstraints", args);
            return ((Long)rets[0]);
        }

        public Long getElementFlags(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.getElementFlags", args);
            return ((Long)rets[0]);
        }

        public List<Double> getElementPrecision(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.getElementPrecision", args);
            return ((List<Double>)rets[0]);
        }

        public List<Double> getElementWeights(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.getElementWeights", args);
            return ((List<Double>)rets[0]);
        }

        public String getFailureDescription(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.getFailureDescription", args);
            return ((String)rets[0]);
        }

        public Object[] getGroupCalculation(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.getGroupCalculation", args);
            return rets;
        }

        public Long getGroupFlags(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.getGroupFlags", args);
            return ((Long)rets[0]);
        }

        public Long getGroupHandle(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.getGroupHandle", args);
            return ((Long)rets[0]);
        }

        public Object[] getGroupJointLimitHits(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.getGroupJointLimitHits", args);
            return rets;
        }

        public List<Long> getGroupJoints(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.getGroupJoints", args);
            return ((List<Long>)rets[0]);
        }

        public Object[] getJointDependency(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.getJointDependency", args);
            return rets;
        }

        public Object[] getJointInterval(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.getJointInterval", args);
            return rets;
        }

        public Double getJointLimitMargin(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.getJointLimitMargin", args);
            return ((Double)rets[0]);
        }

        public List<Double> getJointMatrix(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.getJointMatrix", args);
            return ((List<Double>)rets[0]);
        }

        public Double getJointMaxStepSize(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.getJointMaxStepSize", args);
            return ((Double)rets[0]);
        }

        public Long getJointMode(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.getJointMode", args);
            return ((Long)rets[0]);
        }

        public Double getJointPosition(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.getJointPosition", args);
            return ((Double)rets[0]);
        }

        public Double getJointScrewLead(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.getJointScrewLead", args);
            return ((Double)rets[0]);
        }

        public Object[] getJointTransformation(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.getJointTransformation", args);
            return rets;
        }

        public Long getJointType(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.getJointType", args);
            return ((Long)rets[0]);
        }

        public Double getJointWeight(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.getJointWeight", args);
            return ((Double)rets[0]);
        }

        public Long getObjectHandle(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.getObjectHandle", args);
            return ((Long)rets[0]);
        }

        public List<Double> getObjectMatrix(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.getObjectMatrix", args);
            return ((List<Double>)rets[0]);
        }

        public Long getObjectParent(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.getObjectParent", args);
            return ((Long)rets[0]);
        }

        public List<Double> getObjectPose(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.getObjectPose", args);
            return ((List<Double>)rets[0]);
        }

        public Object[] getObjectTransformation(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.getObjectTransformation", args);
            return rets;
        }

        public Long getObjectType(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.getObjectType", args);
            return ((Long)rets[0]);
        }

        public Object[] getObjects(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.getObjects", args);
            return rets;
        }

        public Long getTargetDummy(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.getTargetDummy", args);
            return ((Long)rets[0]);
        }

        public Object[] handleGroup(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.handleGroup", args);
            return rets;
        }

        public Object[] handleGroups(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.handleGroups", args);
            return rets;
        }

        public void load(Object... args) throws CborException
        {
            this.client.call("simIK.load", args);
        }

        public String save(Object... args) throws CborException
        {
            Object[] rets = this.client.call("simIK.save", args);
            return ((String)rets[0]);
        }

        public void setElementBase(Object... args) throws CborException
        {
            this.client.call("simIK.setElementBase", args);
        }

        public void setElementConstraints(Object... args) throws CborException
        {
            this.client.call("simIK.setElementConstraints", args);
        }

        public void setElementFlags(Object... args) throws CborException
        {
            this.client.call("simIK.setElementFlags", args);
        }

        public void setElementPrecision(Object... args) throws CborException
        {
            this.client.call("simIK.setElementPrecision", args);
        }

        public void setElementWeights(Object... args) throws CborException
        {
            this.client.call("simIK.setElementWeights", args);
        }

        public void setGroupCalculation(Object... args) throws CborException
        {
            this.client.call("simIK.setGroupCalculation", args);
        }

        public void setGroupFlags(Object... args) throws CborException
        {
            this.client.call("simIK.setGroupFlags", args);
        }

        public void setJointDependency(Object... args) throws CborException
        {
            this.client.call("simIK.setJointDependency", args);
        }

        public void setJointInterval(Object... args) throws CborException
        {
            this.client.call("simIK.setJointInterval", args);
        }

        public void setJointLimitMargin(Object... args) throws CborException
        {
            this.client.call("simIK.setJointLimitMargin", args);
        }

        public void setJointMaxStepSize(Object... args) throws CborException
        {
            this.client.call("simIK.setJointMaxStepSize", args);
        }

        public void setJointMode(Object... args) throws CborException
        {
            this.client.call("simIK.setJointMode", args);
        }

        public void setJointPosition(Object... args) throws CborException
        {
            this.client.call("simIK.setJointPosition", args);
        }

        public void setJointScrewLead(Object... args) throws CborException
        {
            this.client.call("simIK.setJointScrewLead", args);
        }

        public void setJointWeight(Object... args) throws CborException
        {
            this.client.call("simIK.setJointWeight", args);
        }

        public void setObjectMatrix(Object... args) throws CborException
        {
            this.client.call("simIK.setObjectMatrix", args);
        }

        public void setObjectParent(Object... args) throws CborException
        {
            this.client.call("simIK.setObjectParent", args);
        }

        public void setObjectPose(Object... args) throws CborException
        {
            this.client.call("simIK.setObjectPose", args);
        }

        public void setObjectTransformation(Object... args) throws CborException
        {
            this.client.call("simIK.setObjectTransformation", args);
        }

        public void setSphericalJointMatrix(Object... args) throws CborException
        {
            this.client.call("simIK.setSphericalJointMatrix", args);
        }

        public void setSphericalJointRotation(Object... args) throws CborException
        {
            this.client.call("simIK.setSphericalJointRotation", args);
        }

        public void setTargetDummy(Object... args) throws CborException
        {
            this.client.call("simIK.setTargetDummy", args);
        }

        public void syncFromSim(Object... args) throws CborException
        {
            this.client.call("simIK.syncFromSim", args);
        }

        public void syncToSim(Object... args) throws CborException
        {
            this.client.call("simIK.syncToSim", args);
        }

    }

    public _simIK simIK() {
        return new _simIK(this.client);
    }

}
