package com.braunster.chatsdk.dao;

import java.util.List;
import com.braunster.chatsdk.dao.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here

import com.braunster.chatsdk.Utils.Debug;
import com.braunster.chatsdk.Utils.JsonHelper;
import com.braunster.chatsdk.Utils.sorter.ThreadsSorter;
import com.braunster.chatsdk.dao.core.DaoCore;
import com.braunster.chatsdk.dao.entities.BThreadEntity;
import com.braunster.chatsdk.dao.entities.BUserEntity;
import com.braunster.chatsdk.network.BDefines;
import com.braunster.chatsdk.network.BFirebaseDefines;
import com.braunster.chatsdk.network.BNetworkManager;
import com.braunster.chatsdk.network.BPath;
import com.braunster.chatsdk.network.events.MessageEventListener;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.greenrobot.dao.DaoException;
import de.greenrobot.dao.Property;
import timber.log.Timber;
// KEEP INCLUDES END
/**
 * Entity mapped to table BUSER.
 */
public class BUser extends BUserEntity  {

    private Long id;
    private String entityID;
    private String messageColor;
    private Boolean Online;
    private String Metadata;
    private Long installationId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient BUserDao myDao;

    private BInstallation installation;
    private Long installation__resolvedKey;

    private List<BUserConnection> BLinkedContacts;
    private List<BUserAccount> BLinkedAccounts;
    private List<BMessage> messages;
    private List<BThread> threadsCreated;
    private List<BLinkData> BLinkData;

    // KEEP FIELDS - put your custom fields here
    private static final String TAG = BUser.class.getSimpleName();
    private static final boolean DEBUG = Debug.BUser;

    private static final String USER_PREFIX = "user";
    // KEEP FIELDS END

    public BUser() {
    }

    public BUser(Long id) {
        this.id = id;
    }

    public BUser(Long id, String entityID, String messageColor, Boolean Online, String Metadata, Long installationId) {
        this.id = id;
        this.entityID = entityID;
        this.messageColor = messageColor;
        this.Online = Online;
        this.Metadata = Metadata;
        this.installationId = installationId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getBUserDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntityID() {
        return entityID;
    }

    public void setEntityID(String entityID) {
        this.entityID = entityID;
    }

    public String getMessageColor() {
        return messageColor;
    }

    public void setMessageColor(String messageColor) {
        this.messageColor = messageColor;
    }

    public Boolean getOnline() {
        return Online;
    }

    public void setOnline(Boolean Online) {
        this.Online = Online;
    }

    public String getMetadata() {
        return Metadata;
    }

    public void setMetadata(String Metadata) {
        this.Metadata = Metadata;
    }

    public Long getInstallationId() {
        return installationId;
    }

    public void setInstallationId(Long installationId) {
        this.installationId = installationId;
    }

    /** To-one relationship, resolved on first access. */
    public BInstallation getInstallation() {
        Long __key = this.installationId;
        if (installation__resolvedKey == null || !installation__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BInstallationDao targetDao = daoSession.getBInstallationDao();
            BInstallation installationNew = targetDao.load(__key);
            synchronized (this) {
                installation = installationNew;
            	installation__resolvedKey = __key;
            }
        }
        return installation;
    }

    public void setInstallation(BInstallation installation) {
        synchronized (this) {
            this.installation = installation;
            installationId = installation == null ? null : installation.getId();
            installation__resolvedKey = installationId;
        }
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<BUserConnection> getBLinkedContacts() {
        if (BLinkedContacts == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BUserConnectionDao targetDao = daoSession.getBUserConnectionDao();
            List<BUserConnection> BLinkedContactsNew = targetDao._queryBUser_BLinkedContacts(id);
            synchronized (this) {
                if(BLinkedContacts == null) {
                    BLinkedContacts = BLinkedContactsNew;
                }
            }
        }
        return BLinkedContacts;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetBLinkedContacts() {
        BLinkedContacts = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<BUserAccount> getBLinkedAccounts() {
        if (BLinkedAccounts == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BUserAccountDao targetDao = daoSession.getBUserAccountDao();
            List<BUserAccount> BLinkedAccountsNew = targetDao._queryBUser_BLinkedAccounts(id);
            synchronized (this) {
                if(BLinkedAccounts == null) {
                    BLinkedAccounts = BLinkedAccountsNew;
                }
            }
        }
        return BLinkedAccounts;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetBLinkedAccounts() {
        BLinkedAccounts = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<BMessage> getMessages() {
        if (messages == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BMessageDao targetDao = daoSession.getBMessageDao();
            List<BMessage> messagesNew = targetDao._queryBUser_Messages(id);
            synchronized (this) {
                if(messages == null) {
                    messages = messagesNew;
                }
            }
        }
        return messages;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetMessages() {
        messages = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<BThread> getThreadsCreated() {
        if (threadsCreated == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BThreadDao targetDao = daoSession.getBThreadDao();
            List<BThread> threadsCreatedNew = targetDao._queryBUser_ThreadsCreated(id);
            synchronized (this) {
                if(threadsCreated == null) {
                    threadsCreated = threadsCreatedNew;
                }
            }
        }
        return threadsCreated;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetThreadsCreated() {
        threadsCreated = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<BLinkData> getBLinkData() {
        if (BLinkData == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BLinkDataDao targetDao = daoSession.getBLinkDataDao();
            List<BLinkData> BLinkDataNew = targetDao._queryBUser_BLinkData(id);
            synchronized (this) {
                if(BLinkData == null) {
                    BLinkData = BLinkDataNew;
                }
            }
        }
        return BLinkData;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetBLinkData() {
        BLinkData = null;
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

    // KEEP METHODS - put your custom methods here

    @Override
    public BPath getBPath() {
        return new BPath().addPathComponent(BFirebaseDefines.Path.BUsers, getEntityID());
    }

    @Override
    public Type getEntityType() {
        return Type.bEntityTypeUser;
    }

    public String[] getCacheIDs(){
        return new String[]{entityID != null ? entityID : ""};
    }

    /** Get a link account of the user by type.
     * @return BLinkedAccount if found
     * @return null if no account found.*/
    public BUserAccount getAccountWithType(int type){
        for (BUserAccount account : getBLinkedAccounts())
        {
            if (account.getType() == type)
                return account;
        }
        return null;
    }

    @Override
    public List<BThread> getThreads(){
        return getThreads(BThreadEntity.Type.NoType);
    }

    @Override
    public List<BThread> getThreads(@BThreadEntity.ThreadType String type){
        return getThreads(type, false);
    }

    /**
     * @param type the type of the threads to get, Pass -1 to get all types.
     * @param allowDeleted if true deleted thread will be returned in the result list
     * @return a list with all the threads.
     ** */
    @Override
    public List<BThread> getThreads(@BThreadEntity.ThreadType String type, boolean allowDeleted){
        /* Getting the thread list by getBLinkData can be out of date so we get the data from the database*/

        List<BThread> threads = new ArrayList<BThread>();
        List<BLinkData> list =  DaoCore.fetchEntitiesWithProperty(BLinkData.class, BLinkDataDao.Properties.UserId, getId());

        if (DEBUG) Timber.d("BUser, getThreads, Amount: %s", (list == null ? "null" : list.size()));

        if (list == null) return null;

        BThread thread;
        boolean checkType = (type.equals(BThreadEntity.Type.OneToOne) || type.equals(BThreadEntity.Type.Public) || type.equals(BThreadEntity.Type.Group));
        for (BLinkData data : list)
        {
            thread = data.getBThread();
            if (thread != null)
            {
                if (DEBUG) Timber.i("Thread, name: %s, deleted: %s", thread.getName(), thread.getDeleted());

                if (!allowDeleted && thread.isDeleted())
                {
                    continue;
                }

                if (!checkType)
                {
                    threads.add(data.getBThread());
                }
                else if (thread.getType() != null && type.equals(thread.getType()))
                    threads.add(thread);
            }
        }

        // Sort the thread in default order.
        Collections.sort(threads, new ThreadsSorter());
        
        return threads;
    }

    @Override
    public void connectUser(BUser user, @BUserConnection.ConnectionType int type) {
        if (user.equals(this))
            return;

        BUserConnection connection;

        if (StringUtils.isNotEmpty(user.getEntityID()))
            connection = DaoCore.fetchEntityWithProperties(BUserConnection.class, new Property[]{BUserConnectionDao.Properties.OwnerId, BUserConnectionDao.Properties.EntityID, BUserConnectionDao.Properties.Type}, getId(), user.getEntityID(), type);

        else return;
        
        boolean exist = connection != null;

        if (!exist)
        {
            BUserConnection linkedContact = new BUserConnection();
            linkedContact.setEntityID(user.getEntityID());
            linkedContact.setType(type);
            // This is the bind value between the LinkedContact to this user.
            linkedContact.setOwnerId(getId());
            DaoCore.createEntity(linkedContact);
        }
    }

    @Override
    public void disconnectUser(BUser user, @BUserConnection.ConnectionType int type) {
        if (user.equals(this))
            return;

        BUserConnection connection = null;

        if (StringUtils.isNotEmpty(user.getEntityID()))
            connection = DaoCore.fetchEntityWithProperties(BUserConnection.class, new Property[]{BUserConnectionDao.Properties.OwnerId, BUserConnectionDao.Properties.EntityID, BUserConnectionDao.Properties.Type}, getId(), user.getEntityID(), type);

        // Deleting the connection
        if (connection != null)
            DaoCore.deleteEntity(connection);
    }

    @Override
    public List<BUser> connectionsWithType(@BUserConnection.ConnectionType int type) {

        List<BUser> connections = new ArrayList<>();

        List<BUserConnection> list =  DaoCore.fetchEntitiesWithProperties(BUserConnection.class,
                new Property[] { BUserConnectionDao.Properties.OwnerId, BUserConnectionDao.Properties.Type},
                getId(), type);

        if (DEBUG) Timber.d(TAG, "BUser, getConnectionWithType, Amount: %s",(list==null?"null":list.size()) );

        BUser user = null;
        for (BUserConnection contact : list)
        {
            if (StringUtils.isNotEmpty(contact.getEntityID()))
            {
                user = DaoCore.fetchEntityWithEntityID(BUser.class, contact.getEntityID());
            }

            if (user != null)
                connections.add(user);
        }

        return connections;
    }

    @Override
    public Date dateOfBirth() {
        String dob = metaStringForKey(BDefines.Keys.BDateOfBirth);

        if (StringUtils.isNotEmpty(dob))
        {
            return new Date(Long.parseLong(dob));
        }

        return null;
    }

    @Override
    public void setPictureUrl(String imageUrl) {
        setMetadataString(BDefines.Keys.BPictureURL, imageUrl);
    }

    @Override
    public String getPictureUrl() {
        return metaStringForKey(BDefines.Keys.BPictureURL);
    }

    @Override
    public String getPictureThumbnail() {
        String thumbnail = metaStringForKey(BDefines.Keys.BPictureURLThumbnail);
        return StringUtils.isEmpty(thumbnail) ? getPictureUrl() : thumbnail;
    }

    @Override
    public void setPictureThumbnail(String thumbnailUrl) {
        setMetadataString(BDefines.Keys.BPictureURLThumbnail, thumbnailUrl);
    }

    @Override
    public void setName(String name) {
        setMetadataString(BDefines.Keys.BName, name);
    }

    @Override
    public String getName() {
        return metaStringForKey(BDefines.Keys.BName);
    }

    @Override
    public void setEmail(String email) {
        setMetadataString(BDefines.Keys.BEmail, email);
    }

    @Override
    public String getEmail() {
        return metaStringForKey(BDefines.Keys.BEmail);
    }

    public String metaStringForKey(String key){
        return (String) metaMap().get(key);
    }

    public void setMetadataString(String key, String value){
        Map<String, Object> map = metaMap();
        map.put(key, value);
        
        setMetaMap(map);
        DaoCore.updateEntity(this);
    }

    /**
     * Setting the metadata, The Map will be converted to a Json String.
     **/
    public void setMetaMap(Map<String, Object> metadata){
        // Notice i dont think that we need it as we only use the new sdk.
//        metadata = updateMetaDataFormat(metadata);
        
        this.Metadata = new JSONObject(metadata).toString();
    }
    
    @Deprecated()
    /**
     * This is for maintaining compatibility with older chat versions, It will be removed in a few versions.
     **/
    private Map<String, Object> updateMetaDataFormat(Map<String, Object> map){
        
        Map<String, Object> newData = new HashMap<>();

        String newKey, value;
        for (String key : map.keySet())
        {
            if (map.get(key) instanceof Map)
            {
                value = (String) ((Map) map.get(key)).get(BDefines.Keys.BValue);
                newKey = (String) ((Map) map.get(key)).get(BDefines.Keys.BKey);
                newData.put(newKey, value);
                
                if (DEBUG) Timber.i("convertedData, Key: %s, Value: %s", newKey, value);
            }
            else 
                newData.put(key, map.get(key));
        }
        
        return newData;
    }

    /**
     * Converting the metadata json to a map object
     **/
    public Map<String, Object> metaMap(){
        if (StringUtils.isEmpty(Metadata))
            return new HashMap<>();

        try {
            return JsonHelper.toMap(new JSONObject(Metadata));
        } catch (JSONException e) {
            e.printStackTrace();
            Timber.e(e.getCause(), "Cant parse metadata json to map. Meta: %s", Metadata);

            return new HashMap<>();
        }
    }

    
    
    
    public boolean hasThread(BThread thread){
        com.braunster.chatsdk.dao.BLinkData data =
                DaoCore.fetchEntityWithProperties(com.braunster.chatsdk.dao.BLinkData.class,
                        new Property[]{BLinkDataDao.Properties.ThreadId, BLinkDataDao.Properties.UserId}, thread.getId(), getId());

        return data != null;
    }

    public String pushChannel(){
        if (entityID == null)
            return "";


        String channel = USER_PREFIX + (getEntityID().replace(":", "_"));

        if (channel.contains("%3A"))
            channel = channel.replace("%3A", "_");
        if (channel.contains("%253A"))
            channel = channel.replace("%253A", "_");

        return channel;
    }

    @Override
    public boolean isMe(){
        return getId().longValue()
                == BNetworkManager.sharedManager().getNetworkAdapter().currentUserModel().getId().longValue();
    }

    @Override
    public boolean isFriend() {
        return BNetworkManager.sharedManager().getNetworkAdapter().currentUserModel()
                .connectionsWithType(BUserConnection.Type.Friend).contains(this);

    }

    @Override
    public boolean isBlocked() {
        return BNetworkManager.sharedManager().getNetworkAdapter().currentUserModel()
                .connectionsWithType(BUserConnection.Type.Blocked).contains(this);
    }

    @Override
    public String toString() {
        return String.format("BUser, id: %s meta: %s", id, getMetadata());
    }
/*






    private BFollower fetchFollower(BUser follower, int type){
        return DaoCore.fetchEntityWithProperties(BFollower.class,
                new Property[]{BFollowerDao.Properties.UserId, BFollowerDao.Properties.OwnerId, BFollowerDao.Properties.Type},
                follower.getId(), getId(),  type);
    }

    @Override
    public List<BUser> getFollowers() {
        List<BUser> users = new ArrayList<BUser>();

        List<BFollower> followers = DaoCore.fetchEntitiesWithProperties(BFollower.class,
                new Property[]{BFollowerDao.Properties.OwnerId, BFollowerDao.Properties.Type},
                getId(), BFollower.Type.FOLLOWER);

        for (BFollower f : followers)
        {
            if (f!=null)
                users.add(f.getUser());
        }

        return users;
    }

    @Override
    public List<BUser> getFollows() {
        List<BUser> users = new ArrayList<BUser>();

        List<BFollower> followers = DaoCore.fetchEntitiesWithProperties(BFollower.class,
                new Property[]{BFollowerDao.Properties.OwnerId, BFollowerDao.Properties.Type},
                getId(), BFollower.Type.FOLLOWS);

        for (BFollower f : followers)
        {
            if (f!=null)
                users.add(f.getUser());
        }

        return users;
    }

    @Override
    public BFollower fetchOrCreateFollower(BUser follower, int type) {

        BFollower follows = fetchFollower(follower, type);

        if (follows== null)
        {
            follows = new BFollower();

            follows.setOwner(this);
            follows.setUser(follower);
            follows.setType(type);

            follows = DaoCore.createEntity(follows);
        }

        return follows;
    }

    public boolean isFollowing(BUser user){
        return fetchFollower(user, BFollower.Type.FOLLOWER) != null;
    }

    public boolean follows(BUser user){
        return fetchFollower(user, BFollower.Type.FOLLOWS) != null;
    }*/
    // KEEP METHODS END

}
